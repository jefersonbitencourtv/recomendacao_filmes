package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.rest.dto.MovieDTO;
import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;
import api.desafio.recomendacao_filmes.service.implementation.OpenWeatherMapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RecommendationsService {
    MoviesByGenreDTO getByReleaseDate(String city);
    MoviesByGenreDTO getByVoteAverage(String city);
    MoviesByGenreDTO getByPopularity(String city);

}
