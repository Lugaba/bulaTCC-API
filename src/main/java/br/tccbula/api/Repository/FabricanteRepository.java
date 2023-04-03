package br.tccbula.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tccbula.api.Entity.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}