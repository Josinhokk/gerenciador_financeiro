package br.com.kayke.organizadorfinanceiro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastrarContratoDto(
        @NotBlank
        String nomeCliente,

        String numeroProcesso,

        @NotNull
        BigDecimal valorTotal,


        Integer numeroParcelas,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate data
) {
}
