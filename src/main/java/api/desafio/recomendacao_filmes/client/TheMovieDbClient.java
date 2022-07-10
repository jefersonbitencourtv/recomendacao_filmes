package api.desafio.recomendacao_filmes.client;

import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="${apithemoviedb.url}", name="TheMovieDbController")
public interface TheMovieDbClient {
    @GetMapping("/discover/movie")
    Response getMoviesByGenderSortByPopularity(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
    @GetMapping("/discover/movie")
    Response getMoviesByGenderSortByReleaseDate(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
    @GetMapping("/discover/movie")
    Response getMoviesByGenderSortByVoteAverage(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
}
