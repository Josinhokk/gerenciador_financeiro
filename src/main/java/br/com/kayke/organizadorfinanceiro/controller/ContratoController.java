package br.com.kayke.organizadorfinanceiro.controller;

import br.com.kayke.organizadorfinanceiro.dto.CadastrarContratoDto;
import br.com.kayke.organizadorfinanceiro.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contrato")
public class ContratoController {

    @Autowired
    ContratoService service;

    @PostMapping
    public ResponseEntity cadastrarContrato(@RequestBody @Valid CadastrarContratoDto dto){
        service.cadastrarContrato(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{mes}")
    public ResponseEntity listarGanhoMensal(@PathVariable int mes){
        return ResponseEntity.ok().body(service.listarGanhoMensal(mes));
    }

    @GetMapping
    public ResponseEntity listarContratos(){
        return ResponseEntity.ok().body(service.listarContratos());
    }

    @GetMapping("parcelas/{id}")
    public ResponseEntity listarParcelasContrato(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listarParcelasContrato(id));
    }

    @GetMapping("parcela/{mes}")
    public ResponseEntity listarParcelasMensal(@PathVariable Integer mes){
        return ResponseEntity.ok().body(service.listarParcelasMes(mes));
    }

    @Transactional
    @PutMapping("parcela/{parcelaId}")
    public ResponseEntity marcarParcelaComoPago(@PathVariable Long parcelaId){
        service.marcarParcelaComoPago(parcelaId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{contratoId}")
    public void removerContrato(@PathVariable Long contratoId){
        service.removerContrato(contratoId);
    }
}
