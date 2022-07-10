package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Movie details")
@Builder
public class MovieDTO {
    @ApiModelProperty(value="Movie title", required = true)
    private String original_title;
    @ApiModelProperty(value="Average vote", required = true)
    private Double vote_average;
}
