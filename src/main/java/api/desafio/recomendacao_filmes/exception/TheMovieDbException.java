package api.desafio.recomendacao_filmes.exception;

import lombok.Getter;

@Getter
public class TheMovieDbException extends RuntimeException {

    private TheMovieDbClass theMovieDbClass;

    public TheMovieDbException(TheMovieDbClass theMovieDbClass){
        super(theMovieDbClass.getText());
        this.theMovieDbClass = theMovieDbClass;
    }
}
