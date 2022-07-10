package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheMovieDbErrorDTO {
    @ApiModelProperty(value="Status code The Movie Db ", required = true)
    private Integer statusCode;
    @ApiModelProperty(value="Status message The Movie Db", required = true)
    private String status_message;
}
