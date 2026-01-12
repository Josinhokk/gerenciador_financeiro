package br.com.kayke.organizadorfinanceiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "parcelas")
@NoArgsConstructor
@AllArgsConstructor
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataParcela;

    private BigDecimal valor;

    @ManyToOne
    private Contrato contrato;

    public Parcela(Date dataParcela, BigDecimal valor) {
        this.dataParcela = dataParcela;
        this.valor = valor;
    }
}
