package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.rest.dto.OpenWeatherMapDTO;

public interface OpenWetherMapService {
    Integer getTempCelsius(String city);
}
