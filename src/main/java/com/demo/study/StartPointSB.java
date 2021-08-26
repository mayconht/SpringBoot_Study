package com.demo.study;

import com.demo.study.domain.Categoria;
import com.demo.study.domain.Produto;
import com.demo.study.repositories.CategoriaRepository;
import com.demo.study.repositories.ProdutoRepository;
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

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {

        SpringApplication.run(StartPointSB.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
         * String... é o mesmo que String[]
         * Pode receber varios parametros.
         * */

        /*
        * Instanciar dados no banco, basicamente um inicializador de banco.
        * */
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Cozinha");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Papel a4", 20.00);
        Produto p3 = new Produto(null, "Mouse", 120.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p3));
        cat2.getProdutos().addAll(Arrays.asList(p1,p2,p3));

        p1.getCategorias().addAll((Arrays.asList(cat1,cat2)));
        p2.getCategorias().addAll((Arrays.asList(cat2)));
        p3.getCategorias().addAll((Arrays.asList(cat1, cat2)));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
