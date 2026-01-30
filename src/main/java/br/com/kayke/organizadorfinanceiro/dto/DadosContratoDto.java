package br.com.kayke.organizadorfinanceiro.dto;

import java.math.BigDecimal;
import java.util.List;

public record DadosContratoDto(
        String nomeCliente,
        String numProcesso,
        BigDecimal valorTotal,
        List<DadoParcelaContratoDto> parcelas
) {
    public DadosContratoDto(String nomeCliente, String numProcesso, BigDecimal valorTotal, List<DadoParcelaContratoDto> parcelas) {
        this.nomeCliente = nomeCliente;
        if (numProcesso == null) {
            this.numProcesso = "";
        }else {
            this.numProcesso = numProcesso;
        }
        this.valorTotal = valorTotal;
        this.parcelas = parcelas;
    }
}
