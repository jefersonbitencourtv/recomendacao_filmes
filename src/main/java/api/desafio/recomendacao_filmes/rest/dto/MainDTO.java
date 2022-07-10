package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Temperature details")
@Builder
public class MainDTO {
    @ApiModelProperty(value="City Temperature", required = true)
    private Integer temp;
}


