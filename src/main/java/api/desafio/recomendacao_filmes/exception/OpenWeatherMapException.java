package api.desafio.recomendacao_filmes.exception;

import lombok.Getter;

@Getter
public class OpenWeatherMapException extends RuntimeException{

    private OpenWeatherMapEnum openWeatherMapEnum;

    public OpenWeatherMapException(OpenWeatherMapEnum openWeatherMapEnum){
        super(openWeatherMapEnum.getText());
        this.openWeatherMapEnum = openWeatherMapEnum;
    }

}
