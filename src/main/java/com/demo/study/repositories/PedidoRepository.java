package com.demo.study.repositories;

import com.demo.study.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/* Camada de acesso de dados
* Interface que define as implementações do JPA Repository
* Ele Le a classe Categoria e aplica as interface do JPA
* */

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
