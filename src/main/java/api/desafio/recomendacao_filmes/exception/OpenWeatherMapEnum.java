package api.desafio.recomendacao_filmes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
@Getter
@AllArgsConstructor
@NoArgsConstructor

public enum OpenWeatherMapEnum {
    ERROR_KEY_API("Key OpenWeatherMap error, Contact the administrator", HttpStatus.UNAUTHORIZED, 1),
    CITY_NOT_FOUND("City not found. City example: Porto Alegre", HttpStatus.NOT_FOUND, 2),
    TOO_MANY_REQUESTS("Too many requests, please wait a moment and try again", HttpStatus.TOO_MANY_REQUESTS, 3),
    ERROR_API("OpenWeatherMap error, contact the administrator, save the error code", HttpStatus.INTERNAL_SERVER_ERROR, 4),
    ERROR_API2("OpenWeatherMap error, contact the administrator, save the error code", HttpStatus.BAD_GATEWAY, 5),
    ERROR_API3("OpenWeatherMap error, contact the administrator, save the error code", HttpStatus.SERVICE_UNAVAILABLE, 6),
    ERROR_API4("OpenWeatherMap error, contact the administrator, save the error code", HttpStatus.GATEWAY_TIMEOUT, 7),
    //Error converting response to object
    ERROR_API5("Contact the administrator, save the error code", HttpStatus.INTERNAL_SERVER_ERROR, 8);


    private String text;
    private HttpStatus status;
    private Integer errorCode;

    public static OpenWeatherMapEnum get(Integer statusCode) {
        return Arrays.stream(values())
                .filter(myEnum -> statusCode == myEnum.getStatus().value())
                .findFirst()
                .orElse(null);
    }
}
