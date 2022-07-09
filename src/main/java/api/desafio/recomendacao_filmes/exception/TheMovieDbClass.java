package api.desafio.recomendacao_filmes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
ErrorCode 150 = Error converting response to object
Other error code is the same code used in the api The Movie DB. https://www.themoviedb.org/documentation/api/status-codes
*/
public class TheMovieDbClass {
    private Integer errorCode;
    private HttpStatus status;
    private String text;
}
