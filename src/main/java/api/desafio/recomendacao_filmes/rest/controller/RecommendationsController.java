package api.desafio.recomendacao_filmes.rest.controller;

import api.desafio.recomendacao_filmes.rest.dto.MoviesByGenreDTO;
import api.desafio.recomendacao_filmes.service.implementation.RecommendationsServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@ApiResponses({
        @ApiResponse(code = 200, message = "Success in finding movies."),
        @ApiResponse(code = 400, message = "Need json for request or invalid request json. <br/>" +
                "Field cannot be empty"),
        @ApiResponse(code = 401, message = "Key OpenWeatherMap error, Contact the administrator. <br/>" +
                "The Movie Db - Authentication failed<br/>" +
                "The Movie Db - Invalid API key: You must be granted a valid key.<br/>" +
                "Account disabled: Your account is no longer active. Contact TMDB if this is an error."),
        @ApiResponse(code = 403, message = "This user has been suspended."),
        @ApiResponse(code = 404, message = "City not found. City example: Porto Alegre.<br/>" +
                "The Movie Db - The resource you requested could not be found."),
        @ApiResponse(code = 422, message = "Invalid parameters: Your request parameters are incorrect."),
        @ApiResponse(code = 429, message = "Too many requests, please wait a moment and try again."),
        @ApiResponse(code = 500, message = "OpenWeatherMap error, contact the administrator, save the error code.<br>" +
                "The Movie Db - Internal error: Something went wrong, contact TMDB." +
                "The Movie Db - failed"),
        @ApiResponse(code = 501, message = "Invalid service: this service does not exist."),
        @ApiResponse(code = 502, message = "OpenWeatherMap error, Contact the administrator, save the error code.<br/>" +
                "The Movie Db - Couldn't connect to the backend server."),
        @ApiResponse(code = 503, message = "OpenWeatherMap error, Contact the administrator, save the error code. <br/>" +
                "The Movie Db - The API is undergoing maintenance. Try again later.<br/>" +
                "The Movie Db - Invalid API key: You must be granted a valid key."),
        @ApiResponse(code = 504, message = "OpenWeatherMap error, Contact the administrator, save the error code.<br/>" +
                "The Movie Db - Your request to the backend server timed out. Try again."),
})
@Api(description = "Feature to search movies", tags = "Recommendations Controller")
public class RecommendationsController {
    private RecommendationsServiceImpl recommendationsServiceImpl;

    @Autowired
    public RecommendationsController(RecommendationsServiceImpl recommendationsServiceImpl) {
        this.recommendationsServiceImpl = recommendationsServiceImpl;

    }
    @ApiOperation(value="Search movies by popularity")
    @GetMapping("popularity")
    public ResponseEntity<MoviesByGenreDTO> getByPopularity(@ApiParam("City name") @RequestParam("city") String city) {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationsServiceImpl.getByPopularity(city));
    }

    @ApiOperation(value="Search movies by release date")
    @GetMapping("release_date")
    public ResponseEntity<MoviesByGenreDTO> getByReleaseDate(@ApiParam("City name") @RequestParam("city") String city) {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationsServiceImpl.getByReleaseDate(city));
    }

    @ApiOperation(value="Search movies by vote average")
    @GetMapping("vote_average")
    public ResponseEntity<MoviesByGenreDTO> getByVoteAverage(@ApiParam("City name") @RequestParam("city") String city) {
        return ResponseEntity.status(HttpStatus.OK).body(recommendationsServiceImpl.getByVoteAverage(city));
    }
}
