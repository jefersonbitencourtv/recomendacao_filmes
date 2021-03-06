package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.client.TheMovieDbClient;
import api.desafio.recomendacao_filmes.domain.enums.MovieGenre;
import api.desafio.recomendacao_filmes.exception.TheMovieDbException;
import api.desafio.recomendacao_filmes.rest.dto.*;
import api.desafio.recomendacao_filmes.service.implementation.TheMovieDbServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.SerializationUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TheMovieDbServiceImplTest {
    @Mock
    private ObjectMapper mapper;

    @Mock
    TheMovieDbClient theMovieDbClient;

    @InjectMocks
    TheMovieDbServiceImpl theMovieDbServiceImpl;

    String api_key = "62a0ec9d3d29119899ade21355016ca2";

    @Test
    public void getMoviesByGenreSortByPopularityTest() throws JsonProcessingException {
        //Builder object mocks
        MovieDTO movieDTO = MovieDTO.builder().vote_average(7.6).original_title("A").build();
        MoviesByGenreDTO expected = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);

        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByPopularity(api_key,"18","popularity.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenReturn(expected);

        MoviesByGenreDTO methodReturn = theMovieDbServiceImpl.getMoviesByGenreSortByPopularity(MovieGenre.ACTION);

        Assert.assertEquals(expected, methodReturn);
    }

    @Test
    public void getMoviesByGenreSortByReleaseDateTest() throws JsonProcessingException {
        //Builder object mocks
        MovieDTO movieDTO = MovieDTO.builder().vote_average(7.6).original_title("A").build();
        MoviesByGenreDTO expected = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByReleaseDate(api_key,"18","release_date.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenReturn(expected);

        MoviesByGenreDTO methodReturn = theMovieDbServiceImpl.getMoviesByGenreSortByReleaseDate(MovieGenre.ACTION);
        Assert.assertEquals(expected, methodReturn);
    }

    @Test
    public void getMoviesByGenreSortByVoteAverageTest() throws JsonProcessingException {
        //Builder object mocks
        MovieDTO movieDTO = MovieDTO.builder().vote_average(7.6).original_title("A").build();
        MoviesByGenreDTO expected = MoviesByGenreDTO.builder().results(Arrays.asList(movieDTO)).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByVoteAverage(api_key,"18","vote_average.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenReturn(expected);

        MoviesByGenreDTO methodReturn = theMovieDbServiceImpl.getMoviesByGenreSortByVoteAverage(MovieGenre.ACTION);
        Assert.assertEquals(expected, methodReturn);
    }

    @Test
    public void getMoviesByGenreSortByVoteAverageDiff200Test() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";
        //Builder object mocks
        TheMovieDbErrorDTO theMovieDbErrorDTO = TheMovieDbErrorDTO.builder().status_message("A").statusCode(400).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(400).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByVoteAverage(api_key,"18","vote_average.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, TheMovieDbErrorDTO.class)).thenReturn(theMovieDbErrorDTO);

        try{
            theMovieDbServiceImpl.getMoviesByGenreSortByVoteAverage(MovieGenre.ACTION);
        }
        catch (TheMovieDbException methodReturn){
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getMoviesByGenreSortByReleaseDateDiff200Test() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";
        //Builder object mocks
        TheMovieDbErrorDTO theMovieDbErrorDTO = TheMovieDbErrorDTO.builder().status_message("A").statusCode(400).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Objeto da response
        Response response = Response.builder().status(400).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByReleaseDate(api_key,"18","release_date.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, TheMovieDbErrorDTO.class)).thenReturn(theMovieDbErrorDTO);

        try{
            theMovieDbServiceImpl.getMoviesByGenreSortByReleaseDate(MovieGenre.ACTION);
        }
        catch (TheMovieDbException methodReturn){
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getMoviesByGenreSortByPopularityDiff200Test() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";
        //Builder object mocks
        TheMovieDbErrorDTO theMovieDbErrorDTO = TheMovieDbErrorDTO.builder().status_message("A").statusCode(400).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Objeto da response
        Response response = Response.builder().status(400).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByPopularity(api_key,"18","popularity.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, TheMovieDbErrorDTO.class)).thenReturn(theMovieDbErrorDTO);

        try{
            theMovieDbServiceImpl.getMoviesByGenreSortByPopularity(MovieGenre.ACTION);
        }
        catch (TheMovieDbException methodReturn){
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getMoviesByGenreSortByPopularityObjectMapperExceptionTest() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByPopularity(api_key,"18","popularity.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenThrow(JsonProcessingException.class);

        try {
            theMovieDbServiceImpl.getMoviesByGenreSortByPopularity(MovieGenre.ACTION);
        } catch (TheMovieDbException methodReturn) {
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getMoviesByGenreSortByReleaseDateObjectMapperExceptionTest() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByReleaseDate(api_key,"18","release_date.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenThrow(JsonProcessingException.class);

        try {
            theMovieDbServiceImpl.getMoviesByGenreSortByReleaseDate(MovieGenre.ACTION);
        } catch (TheMovieDbException methodReturn) {
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getMoviesByGenreSortByVoteAverageObjectMapperExceptionTest() throws JsonProcessingException {
        String expected = "Contact the administrator, save the error code";

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(theMovieDbClient.getMoviesByGenderSortByVoteAverage(api_key,"18","vote_average.desc")).thenReturn(response);
        Mockito.when(mapper.readValue(json, MoviesByGenreDTO.class)).thenThrow(JsonProcessingException.class);

        try {
            theMovieDbServiceImpl.getMoviesByGenreSortByVoteAverage(MovieGenre.ACTION);
        } catch (TheMovieDbException methodReturn) {
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

}
