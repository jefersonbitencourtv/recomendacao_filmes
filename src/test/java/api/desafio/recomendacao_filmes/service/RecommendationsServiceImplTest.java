package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import api.desafio.recomendacao_filmes.rest.dto.MovieDTO;
import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;
import api.desafio.recomendacao_filmes.service.implementation.OpenWeatherMapServiceImpl;
import api.desafio.recomendacao_filmes.service.implementation.RecommendationsServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class RecommendationsServiceImplTest {
    @Mock
    private OpenWeatherMapServiceImpl openWeatherMapService;

    @Mock TheMovieDbService theMovieDbService;

    @InjectMocks
    private RecommendationsServiceImpl recommendationsService;

    @Test
    public void getByReleaseDateTest(){
        Integer temp = 5;
        Mockito.when(openWeatherMapService.getTempCelsius("Porto Alegre")).thenReturn(temp);

        MovieDTO movieDTO = MovieDTO.builder().original_title("Filme1").vote_average(5.0).build();
        MoviesByGenreDTO moviesByGenreDTO = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();
        Mockito.when(theMovieDbService.getMoviesByGenreSortByReleaseDate(MovieGenre.get(temp))).thenReturn(moviesByGenreDTO);
        MoviesByGenreDTO moviesByGenreDTO1 = recommendationsService.getByReleaseDate("Porto Alegre");

        Assert.assertEquals(moviesByGenreDTO, moviesByGenreDTO1);
    }

    @Test
    public void getByVoteAverage(){
        Integer temp = 5;
        Mockito.when(openWeatherMapService.getTempCelsius("Porto Alegre")).thenReturn(temp);

        MovieDTO movieDTO = MovieDTO.builder().original_title("Filme1").vote_average(5.0).build();
        MoviesByGenreDTO moviesByGenreDTO = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();
        Mockito.when(theMovieDbService.getMoviesByGenreSortByVoteAverage(MovieGenre.get(temp))).thenReturn(moviesByGenreDTO);
        MoviesByGenreDTO moviesByGenreDTO1 = recommendationsService.getByVoteAverage("Porto Alegre");

        Assert.assertEquals(moviesByGenreDTO, moviesByGenreDTO1);
    }

    @Test
    public void getByPopularity(){
        Integer temp = 5;
        Mockito.when(openWeatherMapService.getTempCelsius("Porto Alegre")).thenReturn(temp);

        MovieDTO movieDTO = MovieDTO.builder().original_title("Filme1").vote_average(5.0).build();
        MoviesByGenreDTO moviesByGenreDTO = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();
        Mockito.when(theMovieDbService.getMoviesByGenreSortByPopularity(MovieGenre.get(temp))).thenReturn(moviesByGenreDTO);
        MoviesByGenreDTO moviesByGenreDTO1 = recommendationsService.getByPopularity("Porto Alegre");

        Assert.assertEquals(moviesByGenreDTO, moviesByGenreDTO1);
    }
}
