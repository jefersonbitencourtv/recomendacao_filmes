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
    Response getFilmesByGenderSortByPopularity(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
    @GetMapping("/discover/movie")
    Response getFilmesByGenderSortByReleaseDate(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
    @GetMapping("/discover/movie")
    Response getFilmesByGenderSortByVoteAverage(@RequestParam String api_key, @RequestParam("with_genres") String idGenre, @RequestParam String sort_by);
}
