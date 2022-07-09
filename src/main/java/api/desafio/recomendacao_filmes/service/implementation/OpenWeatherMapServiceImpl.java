package api.desafio.recomendacao_filmes.service.implementation;

import api.desafio.recomendacao_filmes.client.OpenWeatherMapClient;
import api.desafio.recomendacao_filmes.exception.OpenWeatherMapEnum;
import api.desafio.recomendacao_filmes.exception.OpenWeatherMapException;
import api.desafio.recomendacao_filmes.rest.dto.OpenWeatherMapDTO;
import api.desafio.recomendacao_filmes.service.OpenWetherMapService;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class OpenWeatherMapServiceImpl implements OpenWetherMapService {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final ObjectMapper mapper;
    private final String api_key = "af5dc93d6fed25c222420cec68f10ed4";

    public OpenWeatherMapServiceImpl(OpenWeatherMapClient openWeatherMapClient, ObjectMapper mapper) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.mapper = mapper;
    }

    @Override
    public Integer getTempCelsius(String city){
        try {
            Response response = openWeatherMapClient.getTempByApi(city, api_key, "metric");
            if(response.status() != 200){
                throw new OpenWeatherMapException(OpenWeatherMapEnum.get(response.status()));
            }
            String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            OpenWeatherMapDTO openWeatherMapDTO = mapper.readValue(bodyStr, OpenWeatherMapDTO.class);
            return openWeatherMapDTO.getMain().getTemp();
        } catch (IOException e) {
            throw new OpenWeatherMapException(OpenWeatherMapEnum.ERROR_API5);
        }
    }
}
