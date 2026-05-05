package br.com.fiap.apiComidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.apiComidas.model.CategoriaComida;

@Repository
public interface CategoriaComidaRepository extends JpaRepository<CategoriaComida, Long> {

}
