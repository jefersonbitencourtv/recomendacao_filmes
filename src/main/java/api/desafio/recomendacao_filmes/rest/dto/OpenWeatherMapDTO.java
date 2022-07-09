package api.desafio.recomendacao_filmes.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OpenWeatherMapDTO {
    private MainDTO main;
}
