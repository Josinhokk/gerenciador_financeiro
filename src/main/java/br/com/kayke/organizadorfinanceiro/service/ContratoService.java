package br.com.kayke.organizadorfinanceiro.service;

import br.com.kayke.organizadorfinanceiro.dto.CadastrarContratoDto;
import br.com.kayke.organizadorfinanceiro.model.Contrato;
import br.com.kayke.organizadorfinanceiro.repository.ContratoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;



    public void cadastrarContrato(@Valid CadastrarContratoDto dto) {
        Contrato contrato = new Contrato(dto.nomeCliente(), dto.numeroProcesso(), dto.valorTotal(),dto.numeroParcelas(),dto.date());
        Integer parcelas = dto.numeroParcelas();
        Integer valorParcela = (parcelas / dto.valorTotal().intValue());
        Date dataInicio = dto.date();
        for(int i = 0; i<parcelas; i++){
            
        }
    }
}
