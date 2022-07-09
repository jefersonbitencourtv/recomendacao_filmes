package api.desafio.recomendacao_filmes.service;

import api.desafio.recomendacao_filmes.client.OpenWeatherMapClient;
import api.desafio.recomendacao_filmes.exception.OpenWeatherMapException;
import api.desafio.recomendacao_filmes.rest.dto.MainDTO;
import api.desafio.recomendacao_filmes.rest.dto.OpenWeatherMapDTO;
import api.desafio.recomendacao_filmes.service.implementation.OpenWeatherMapServiceImpl;
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
import java.util.*;

@SpringBootTest
public class OpenWeatherMapServiceImplTest {
    @Mock
    private OpenWeatherMapClient openWeatherMapClient;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private OpenWeatherMapServiceImpl openWeatherMapServiceImpl;

    private String api_key = "af5dc93d6fed25c222420cec68f10ed4";

    @Test
    public void getTempCelsius() throws JsonProcessingException {
        String city = "Porto Alegre";

        MainDTO mainDTO = MainDTO.builder().temp(5).build();
        OpenWeatherMapDTO openWeatherMapDTO = OpenWeatherMapDTO.builder().main(mainDTO).build();

        //Objeto da request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Objeto da response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenReturn(openWeatherMapDTO);

        Integer temp = openWeatherMapServiceImpl.getTempCelsius(city);
        Integer number = 5;
        Assert.assertEquals(temp, number);
    }

    @Test
    public void getTempCelsiusStatusDif200() throws OpenWeatherMapException, JsonProcessingException {
        String message = "OpenWeatherMap error, contact the administrator, save the error code";
        String city = "Porto Alegre";

        MainDTO mainDTO = MainDTO.builder().temp(5).build();
        OpenWeatherMapDTO openWeatherMapDTO = OpenWeatherMapDTO.builder().main(mainDTO).build();

        //Objeto da request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Objeto da response
        Response response = Response.builder().status(500).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenReturn(openWeatherMapDTO);

        try {
            openWeatherMapServiceImpl.getTempCelsius(city);
        } catch (OpenWeatherMapException e) {
            Assert.assertEquals(e.getMessage(), message);
        }
    }

    @Test
    public void getTempCelsiusStatus_2() throws OpenWeatherMapException, JsonProcessingException {
        String city = "Porto Alegre";
        String message = "Contact the administrator, save the error code";
        MainDTO mainDTO = MainDTO.builder().temp(5).build();
        OpenWeatherMapDTO openWeatherMapDTO = OpenWeatherMapDTO.builder().main(mainDTO).build();

        //Objeto da request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Objeto da response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenThrow(JsonProcessingException.class);

        try {
            openWeatherMapServiceImpl.getTempCelsius(city);
        } catch (OpenWeatherMapException e) {
            Assert.assertEquals(e.getMessage(), message);
        }
    }
}
