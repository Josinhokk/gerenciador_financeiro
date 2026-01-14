package br.com.kayke.organizadorfinanceiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contratos")
@Getter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;

    private String numProcesso;

    private BigDecimal valorTotal;

    private Integer numParcelas;

    private LocalDate dataInicio;

    @OneToMany(mappedBy = "contrato")
    private List<Parcela> parcela;

    public Contrato(String nomeCliente, String numProcesso, BigDecimal valorTotal, Integer numParcelas, LocalDate data) {
        this.nomeCliente = nomeCliente;
        this.numProcesso = numProcesso;
        this.valorTotal = valorTotal;
        this.numParcelas = numParcelas;
        this.dataInicio = data;
    }

}
