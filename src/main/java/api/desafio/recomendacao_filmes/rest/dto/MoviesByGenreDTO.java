package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(description = "List movies by genre")
public class MoviesByGenreDTO {
    @ApiModelProperty(value="Movies list", required = true)
    private List<MovieDTO> results;
}
