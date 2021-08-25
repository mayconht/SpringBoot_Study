package com.demo.study.services;

import com.demo.study.domain.Categoria;
import com.demo.study.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/*
* O Service Alimenta o Resource com as funções necessárias para os endpoints.
* Basicamente é uma camada de manipulação de dados que serve de ponte entre o Resource e o Repository */
@Service
public class CategoriaService {

    /*Autowired injeta as dependencias de repo direto na classe (de forma porca)
o que retira a necessidade de instanciar a classe (NEW) existem mais coisas
nesse sentido, mas que não são relevantes Agora.
 */
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        /*O Optional é uma longa discussão sobre o tipo de obj, que pode ser ou não nulo. presente desde o Java 1.8
        para definir se um valor está ou não presente apos a execucao da consulta */
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}