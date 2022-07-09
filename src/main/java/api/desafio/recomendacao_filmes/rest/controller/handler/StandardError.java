package api.desafio.recomendacao_filmes.rest.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class StandardError {
    private LocalDateTime timestamp;
    private Integer status;
    private Integer errorCode;
    private String message;
}
