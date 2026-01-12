package br.com.kayke.organizadorfinanceiro.repository;

import br.com.kayke.organizadorfinanceiro.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
