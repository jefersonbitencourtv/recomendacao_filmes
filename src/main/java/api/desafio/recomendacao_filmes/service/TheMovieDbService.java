package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;

import java.io.IOException;

public interface TheMovieDbService {
    MoviesByGenreDTO getMoviesByGenreSortByPopularity(MovieGenre genre);
    MoviesByGenreDTO getMoviesByGenreSortByReleaseDate(MovieGenre genre);
    MoviesByGenreDTO getMoviesByGenreSortByVoteAverage(MovieGenre genre);
}
