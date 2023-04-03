package br.tccbula.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tccbula.api.Entity.Bula;

@Repository
public interface BulaRepository extends JpaRepository<Bula, Long> {
}