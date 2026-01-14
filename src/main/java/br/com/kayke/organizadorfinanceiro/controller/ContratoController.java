package br.com.kayke.organizadorfinanceiro.controller;

import br.com.kayke.organizadorfinanceiro.dto.CadastrarContratoDto;
import br.com.kayke.organizadorfinanceiro.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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



}
