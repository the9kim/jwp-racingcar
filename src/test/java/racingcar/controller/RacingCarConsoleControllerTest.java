package racingcar.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import racingcar.controller.dto.GameInformationDto;
import racingcar.util.NumberGenerator;
import racingcar.util.TestNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RacingCarConsoleControllerTest {

    @TestConfiguration
    static class TestSpringConfig {

        @Bean
        public NumberGenerator numberGenerator() {
            return new TestNumberGenerator(new ArrayList<>(List.of(7, 3, 7, 3, 7, 3, 7, 2, 7, 2, 7, 2)));
        }
    }

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("/plays로 연결이 잘 되는지 확인")
    @Test
    void createGame() {
        GameInformationDto gameInformationDto = new GameInformationDto("roy,jamie", 3);

        RestAssured.given()
                   .log()
                   .all()
                   .contentType(MediaType.APPLICATION_JSON_VALUE)
                   .body(gameInformationDto)
                   .when()
                   .post("/plays")
                   .then()
                   .log()
                   .all()
                   .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("/plays로 기대하는 값이 반환되는지 확인")
    @Test
    void createGameReturn() {
        GameInformationDto gameInformationDto = new GameInformationDto("roy,jamie", 3);

        RestAssured.given()
                   .log()
                   .all()
                   .contentType(MediaType.APPLICATION_JSON_VALUE)
                   .body(gameInformationDto)
                   .when()
                   .post("/plays")
                   .then()
                   .log()
                   .all()
                   .statusCode(HttpStatus.OK.value())
                   .body("winners", is("roy"));
    }
}
