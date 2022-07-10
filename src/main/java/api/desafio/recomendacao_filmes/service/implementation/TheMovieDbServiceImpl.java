package api.desafio.recomendacao_filmes.service.implementation;

import api.desafio.recomendacao_filmes.client.TheMovieDbClient;
import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import api.desafio.recomendacao_filmes.exception.TheMovieDbClass;
import api.desafio.recomendacao_filmes.exception.TheMovieDbException;
import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;
import api.desafio.recomendacao_filmes.rest.dto.TheMovieDbErrorDTO;
import api.desafio.recomendacao_filmes.service.TheMovieDbService;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class TheMovieDbServiceImpl implements TheMovieDbService {
    public final TheMovieDbClient theMovieDbClient;
    public final String apiKey = "62a0ec9d3d29119899ade21355016ca2";
    private final ObjectMapper mapper;

    @Autowired
    public TheMovieDbServiceImpl(TheMovieDbClient theMovieDbClient, ObjectMapper mapper) {
        this.theMovieDbClient = theMovieDbClient;
        this.mapper = mapper;
    }

    @Override
    public MoviesByGenreDTO getMoviesByGenreSortByPopularity(MovieGenre genre){
        try {
            Response response = theMovieDbClient.getMoviesByGenderSortByPopularity(apiKey, genre.getId(), "popularity.desc");
            if(response.status() != 200){
                String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                TheMovieDbErrorDTO theMovieDbErrorDTO = mapper.readValue(bodyStr, TheMovieDbErrorDTO.class);

                HttpStatus status = HttpStatus.valueOf(theMovieDbErrorDTO.getStatusCode());
                Integer statusCode = theMovieDbErrorDTO.getStatusCode();

                TheMovieDbClass theMovieDbClass = new TheMovieDbClass(statusCode, status, "Contact the administrator, save the error code");
                throw new TheMovieDbException(theMovieDbClass);
            }
            String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            MoviesByGenreDTO moviesByGenreDTO = mapper.readValue(bodyStr, MoviesByGenreDTO.class);
            return moviesByGenreDTO;

        }catch (IOException e){
            return null;
        }
    }

    @Override
    public MoviesByGenreDTO getMoviesByGenreSortByReleaseDate(MovieGenre genre) {
        try {
            Response response = theMovieDbClient.getMoviesByGenderSortByReleaseDate(apiKey, genre.getId(), "release_date.desc");
            System.out.println(response);
            if(response.status() != 200){
                String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                TheMovieDbErrorDTO theMovieDbErrorDTO = mapper.readValue(bodyStr, TheMovieDbErrorDTO.class);

                HttpStatus status = HttpStatus.valueOf(theMovieDbErrorDTO.getStatusCode());
                Integer statusCode = theMovieDbErrorDTO.getStatusCode();

                TheMovieDbClass theMovieDbClass = new TheMovieDbClass(statusCode, status, "Contact the administrator, save the error code");
                throw new TheMovieDbException(theMovieDbClass);
            }
            String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            MoviesByGenreDTO moviesByGenreDTO = mapper.readValue(bodyStr, MoviesByGenreDTO.class);
            return moviesByGenreDTO;

        }catch (IOException e){
            return null;
        }
    }

    @Override
    public MoviesByGenreDTO getMoviesByGenreSortByVoteAverage(MovieGenre genre) {
        try {
            Response response = theMovieDbClient.getMoviesByGenderSortByVoteAverage(apiKey, genre.getId(), "vote_average.desc");
            System.out.println(response);
            if(response.status() != 200){
                String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                TheMovieDbErrorDTO theMovieDbErrorDTO = mapper.readValue(bodyStr, TheMovieDbErrorDTO.class);

                HttpStatus status = HttpStatus.valueOf(theMovieDbErrorDTO.getStatusCode());
                Integer statusCode = theMovieDbErrorDTO.getStatusCode();

                TheMovieDbClass theMovieDbClass = new TheMovieDbClass(statusCode, status, "Contact the administrator, save the error code");
                throw new TheMovieDbException(theMovieDbClass);
            }
            String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            MoviesByGenreDTO moviesByGenreDTO = mapper.readValue(bodyStr, MoviesByGenreDTO.class);
            return moviesByGenreDTO;

        }catch (IOException e){
            TheMovieDbClass theMovieDbClass =  new TheMovieDbClass(150, HttpStatus.INTERNAL_SERVER_ERROR, "Contact the administrator, save the error code");
            throw new TheMovieDbException(theMovieDbClass);
        }
    }
}
