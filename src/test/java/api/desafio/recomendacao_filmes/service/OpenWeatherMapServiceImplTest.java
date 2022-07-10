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
    public void getTempCelsiusTest() throws JsonProcessingException {
        String city = "Porto Alegre";
        //Builder object mocks
        MainDTO mainDTO = MainDTO.builder().temp(5).build();
        OpenWeatherMapDTO openWeatherMapDTO = OpenWeatherMapDTO.builder().main(mainDTO).build();

        //Request object
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("test");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Response object
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenReturn(openWeatherMapDTO);

        Integer returnMethod = openWeatherMapServiceImpl.getTempCelsius(city);
        Integer expected = 5;
        Assert.assertEquals(expected, returnMethod);
    }

    @Test
    public void getTempCelsiusStatusDif200Test() throws OpenWeatherMapException, JsonProcessingException {
        String expected = "OpenWeatherMap error, contact the administrator, save the error code";
        String city = "Porto Alegre";

        //Builder object mocks
        MainDTO mainDTO = MainDTO.builder().temp(5).build();
        OpenWeatherMapDTO openWeatherMapDTO = OpenWeatherMapDTO.builder().main(mainDTO).build();

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(500).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenReturn(openWeatherMapDTO);

        try {
            openWeatherMapServiceImpl.getTempCelsius(city);
        } catch (OpenWeatherMapException methodReturn) {
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }

    @Test
    public void getTempCelsiusObjectMapperExceptionTest() throws OpenWeatherMapException, JsonProcessingException {
        String city = "Porto Alegre";
        String expected = "Contact the administrator, save the error code";

        //Object request
        String json = "(main=(MainDTO(temp=5))";
        byte[] data = SerializationUtils.serialize("ts");
        Map<String, Collection<String>> headers = new HashMap<>();
        Request request = Request.create(Request.HttpMethod.GET, "www.google.com.br", headers, data, StandardCharsets.UTF_8);
        //Object response
        Response response = Response.builder().status(200).body(json, StandardCharsets.UTF_8).request(request).build();

        Mockito.when(openWeatherMapClient.getTempByApi(city, api_key, "metric")).thenReturn(response);
        Mockito.when(mapper.readValue(json, OpenWeatherMapDTO.class)).thenThrow(JsonProcessingException.class);

        try {
            openWeatherMapServiceImpl.getTempCelsius(city);
        } catch (OpenWeatherMapException methodReturn) {
            Assert.assertEquals(methodReturn.getMessage(), expected);
        }
    }
}
