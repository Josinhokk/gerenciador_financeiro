package br.com.kayke.organizadorfinanceiro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoParcelaMesDto(
        BigDecimal valor,
        LocalDate data
) {
}
