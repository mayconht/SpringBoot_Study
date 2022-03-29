package com.estudos.spring.repositories;

import com.estudos.spring.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<City, Integer> {
}
