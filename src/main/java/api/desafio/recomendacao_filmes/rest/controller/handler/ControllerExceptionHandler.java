package api.desafio.recomendacao_filmes.rest.controller.handler;

import api.desafio.recomendacao_filmes.exception.OpenWeatherMapException;
import api.desafio.recomendacao_filmes.exception.TheMovieDbException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
@RestControllerAdvice
@ControllerAdvice
/*
ErrorCode 100 is field empty or null
ErrorCode 110 Invalid request json
 */
public class ControllerExceptionHandler {
    @ExceptionHandler(OpenWeatherMapException.class)
    public ResponseEntity<StandardError> OpenWeatherMapException(OpenWeatherMapException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), e.getOpenWeatherMapEnum().getStatus().value(), e.getOpenWeatherMapEnum().getErrorCode(), e.getMessage());
        return ResponseEntity.status(e.getOpenWeatherMapEnum().getStatus()).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidException(MethodArgumentNotValidException  e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), 400, 100 , e.getBindingResult().getAllErrors().stream().map(err -> err.getDefaultMessage()).findFirst().orElse("Field cannot be empty"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(TheMovieDbException.class)
    public ResponseEntity<StandardError> TheMovieDbException(TheMovieDbException  e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), e.getTheMovieDbClass().getStatus().value(), e.getTheMovieDbClass().getErrorCode(), e.getMessage());
        return ResponseEntity.status(e.getTheMovieDbClass().getStatus()).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> HttpMessageNotReadableException(HttpMessageNotReadableException  e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), 400, 110 , "Need json for request or invalid request json");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



}
