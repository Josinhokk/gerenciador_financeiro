package br.com.kayke.organizadorfinanceiro.repository;

import br.com.kayke.organizadorfinanceiro.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    List<Parcela> findByDataParcelaBetween(LocalDate dataParcelaAfter, LocalDate dataParcelaBefore);

    List<Parcela> findByDataParcelaMonthEquals(Integer mes);
}
