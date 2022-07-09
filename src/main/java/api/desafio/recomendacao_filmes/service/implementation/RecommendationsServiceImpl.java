package api.desafio.recomendacao_filmes.service.implementation;

import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;
import api.desafio.recomendacao_filmes.service.RecommendationsService;
import api.desafio.recomendacao_filmes.service.TheMovieDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    private OpenWeatherMapServiceImpl openWeatherMapServiceImpl;
    private TheMovieDbService theMovieDbService;

    @Autowired
    public RecommendationsServiceImpl(OpenWeatherMapServiceImpl openWeatherMapServiceImpl, TheMovieDbService theMovieDbService) {
        this.openWeatherMapServiceImpl = openWeatherMapServiceImpl;
        this.theMovieDbService = theMovieDbService;
    }

    @Override
    public MoviesByGenreDTO getByReleaseDate(String city) {
        System.out.println(city);
        Integer temp = openWeatherMapServiceImpl.getTempCelsius(city);
        return theMovieDbService.getMoviesByGenreSortByReleaseDate(MovieGenre.get(temp));
    }

    @Override
    public MoviesByGenreDTO getByVoteAverage(String city) {
        Integer temp = openWeatherMapServiceImpl.getTempCelsius(city);
        return theMovieDbService.getMoviesByGenreSortByVoteAverage(MovieGenre.get(temp));

    }

    @Override
    public MoviesByGenreDTO getByPopularity(String city) {
        Integer temp = openWeatherMapServiceImpl.getTempCelsius(city);
        return theMovieDbService.getMoviesByGenreSortByPopularity(MovieGenre.get(temp));
    }
}
