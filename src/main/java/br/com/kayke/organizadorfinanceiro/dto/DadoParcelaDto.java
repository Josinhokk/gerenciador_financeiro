package br.com.kayke.organizadorfinanceiro.dto;

import br.com.kayke.organizadorfinanceiro.model.Parcela;

import java.math.BigDecimal;

public record DadoParcelaDto(
        BigDecimal valor
) {

    }

