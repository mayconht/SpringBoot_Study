package com.estudos.spring.services;

import com.estudos.spring.domain.Categoria;
import com.estudos.spring.repositories.CategoriaRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired // Injeção de Dependencia, não há necessidade de instanciar. (inversão de controle)
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
