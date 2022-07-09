package api.desafio.recomendacao_filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients({"api.desafio.recomendacao_filmes.client"})
public class RecomendacaoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendacaoFilmesApplication.class, args);
	}

}
