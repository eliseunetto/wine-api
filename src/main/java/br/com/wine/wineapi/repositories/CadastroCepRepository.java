package br.com.wine.wineapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wine.wineapi.domain.CadastroCep;

@Repository
public interface CadastroCepRepository extends JpaRepository<CadastroCep, Long> {

}
