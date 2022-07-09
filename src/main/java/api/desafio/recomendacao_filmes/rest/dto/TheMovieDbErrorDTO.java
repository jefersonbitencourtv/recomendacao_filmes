package api.desafio.recomendacao_filmes.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TheMovieDbErrorDTO {
    private Integer statusCode;
    private String status_message;
}
