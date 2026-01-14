package br.com.kayke.organizadorfinanceiro.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContratoException.class)
    public ResponseEntity<ContratoException> handleErro(ContratoException ex) {
        return ResponseEntity.badRequest().body(ex);
    }
}
