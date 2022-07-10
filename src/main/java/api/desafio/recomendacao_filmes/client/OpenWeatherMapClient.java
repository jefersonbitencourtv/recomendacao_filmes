package api.desafio.recomendacao_filmes.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="${apiopenweathermap.url}", name="OpenWeatherMapController")
public interface OpenWeatherMapClient {
    @GetMapping
    Response getTempByApi(@RequestParam("q") String cityName, @RequestParam("appid") String api_key, @RequestParam("units") String measure);

}
