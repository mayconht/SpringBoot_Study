package com.demo.study.repositories;

import com.demo.study.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/* Camada de acesso de dados
* Interface que define as implementações do JPA Repository
* Ele Le a classe Categoria e aplica as interface do JPA
* */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
