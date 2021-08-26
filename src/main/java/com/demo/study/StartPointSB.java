package com.demo.study;

import com.demo.study.domain.Categoria;
import com.demo.study.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;


/*
* Aqui é como uma classe main comum do Java.
* é Necessario colocar o annotation do SpringBoot que define ele como uma aplicação SpringBoot
* Com isso é possivel chamar a subinterface RUN que define o startpoint.class (parametros pro spring)
* */
@SpringBootApplication
public class StartPointSB implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {

        SpringApplication.run(StartPointSB.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        * Instanciar dados no banco, basicamente um inicializador de banco.
        * */
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Cozinha");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        /*
        * String... é o mesmo que String[]
        * Pode receber varios parametros.
        * */

    }
}
