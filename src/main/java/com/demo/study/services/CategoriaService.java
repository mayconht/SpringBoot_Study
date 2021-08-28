package com.demo.study.services;

import com.demo.study.domain.Categoria;
import com.demo.study.repositories.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/*
 * O Service Alimenta o Resource com as funções necessárias para os endpoints.
 * Basicamente é uma camada de manipulação de dados que serve de ponte entre o Resource e o Repository */
@Service
public class CategoriaService {

    /*Autowired injeta as dependencies de repo direto na classe
        o que retira a necessidade de instanciar a classe (NEW) existem mais coisas
        nesse sentido, mas que não são relevantes Agora.
    */
    @Autowired
    private CategoriaRepository repo;

        /*O Optional é uma longa discussão sobre o tipo de obj, que pode ser ou não nulo. Presente desde o Java 1.8
        para definir se um valor está ou não presente apos a execucao da consulta */
    public Categoria buscar(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
