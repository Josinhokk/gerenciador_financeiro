package br.com.kayke.organizadorfinanceiro.repository;

import br.com.kayke.organizadorfinanceiro.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
