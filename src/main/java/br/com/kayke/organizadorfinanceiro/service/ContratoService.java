package br.com.kayke.organizadorfinanceiro.service;

import br.com.kayke.organizadorfinanceiro.dto.CadastrarContratoDto;
import br.com.kayke.organizadorfinanceiro.model.Contrato;
import br.com.kayke.organizadorfinanceiro.model.Parcela;
import br.com.kayke.organizadorfinanceiro.repository.ContratoRepository;
import br.com.kayke.organizadorfinanceiro.repository.ParcelaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;
import java.util.List;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;

    @Autowired
    ParcelaRepository parcelaRepository;



    public void cadastrarContrato(@Valid CadastrarContratoDto dto) {
        Contrato contrato = new Contrato(dto.nomeCliente(), dto.numeroProcesso(), dto.valorTotal(),dto.numeroParcelas(),dto.data());
        contratoRepository.save(contrato);
        gerarParcelas(dto.numeroParcelas(), dto.valorTotal(),dto.data(), contrato);

    }

    public void gerarParcelas(Integer numeroParcelas , BigDecimal valorTotal, LocalDate dataInicio, Contrato contrato) {
        BigDecimal valorParcela = valorTotal.divide(BigDecimal.valueOf(numeroParcelas),2, RoundingMode.DOWN);

        BigDecimal totalBase = valorParcela.multiply(BigDecimal.valueOf(numeroParcelas));
        BigDecimal diferenca = valorTotal.subtract(totalBase);
        for(int i = 0; i<numeroParcelas; i++){
            Parcela parcela = new Parcela(dataInicio.plusMonths(i), valorParcela);
            if(i == numeroParcelas - 1) {
                parcela.setValor(valorParcela.add(diferenca));
            }
            parcela.setContrato(contrato);
            parcelaRepository.save(parcela);
        }
    }

    public BigDecimal listarGanhoMensal(int mes) {
        LocalDate dataReferencia = LocalDate.of(LocalDate.now().getYear(), mes, 1);
        LocalDate dataFinal = dataReferencia.plusMonths(1).minusDays(1);
        List<Parcela> parcelas = parcelaRepository.findByDataParcelaBetween(dataReferencia, dataFinal);
        BigDecimal valorTotal = parcelas.stream().map(Parcela::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        return valorTotal;
    }
}
