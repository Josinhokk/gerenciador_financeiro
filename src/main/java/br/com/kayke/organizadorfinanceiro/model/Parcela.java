package br.com.kayke.organizadorfinanceiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "parcelas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataParcela;

    private BigDecimal valor;

    @ManyToOne
    private Contrato contrato;

    public Parcela(LocalDate dataParcela, BigDecimal valor) {
        this.dataParcela = dataParcela;
        this.valor = valor;
    }
}
