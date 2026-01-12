package br.com.kayke.organizadorfinanceiro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record CadastrarContratoDto(
        @NotBlank
        String nomeCliente,

        String numeroProcesso,

        @NotNull
        BigDecimal valorTotal,


        Integer numeroParcelas,

        Date date
) {
}
