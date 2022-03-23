package com.estudos.spring.repositories;


import com.estudos.spring.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
//Todas as implementações possiveis serão herdadas da interfaçe, O JPA cuida de do DAO.
}
