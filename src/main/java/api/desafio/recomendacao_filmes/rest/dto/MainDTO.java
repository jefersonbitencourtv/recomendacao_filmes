package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Temperature details")
@Builder
@ToString
public class MainDTO {
    @ApiModelProperty(value="City Temperature", required = true)
    private Integer temp;
}


