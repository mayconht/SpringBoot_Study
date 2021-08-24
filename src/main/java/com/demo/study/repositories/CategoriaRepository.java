package com.demo.study.repositories;

import com.demo.study.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Camada de Acesso a Dados
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
