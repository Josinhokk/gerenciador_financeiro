package br.com.kayke.organizadorfinanceiro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratoResumoDto(
        Long id,

         String nomeCliente,

         String numProcesso,

         BigDecimal valorTotal,

         Integer numParcelas,

         LocalDate dataInicio) {
}
