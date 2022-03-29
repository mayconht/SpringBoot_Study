package com.estudos.spring.repositories;

import com.estudos.spring.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<State, Integer> {
}
