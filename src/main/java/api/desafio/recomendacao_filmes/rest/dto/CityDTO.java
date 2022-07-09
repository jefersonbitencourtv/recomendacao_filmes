package api.desafio.recomendacao_filmes.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "City details")
public class CityDTO {

    @NotNull(message = "City cannot be null")
    @NotEmpty(message = "City cannot be empty")
    @ApiModelProperty(value="City name", required = true)
    private String city;
}
