package br.com.kayke.organizadorfinanceiro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoParcelaContratoDto(
        BigDecimal valor,
        LocalDate dataParcela,
        Boolean pago
) {

}
