package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenWeatherMapDTO {
    @ApiModelProperty(value="Main temp", required = true)
    private MainDTO main;
}
