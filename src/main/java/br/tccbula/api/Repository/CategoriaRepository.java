package br.tccbula.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tccbula.api.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
