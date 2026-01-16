package br.com.kayke.organizadorfinanceiro.exception;

import br.com.kayke.organizadorfinanceiro.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContratoException.class)
    public ResponseEntity<ApiError> handleErro(ContratoException ex) {

        ApiError error = new ApiError(
                404,
                "Erro",
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
