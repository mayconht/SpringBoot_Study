package com.estudos.spring;

import com.estudos.spring.domain.Categoria;
import com.estudos.spring.domain.Produto;
import com.estudos.spring.repositories.CategoriaRepository;
import com.estudos.spring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;

	@Override
	public void run(String... args) throws Exception {
//	 	Only use with H2 database (temporary data)
//		Categoria cat1 = new Categoria(null, "Informática");
//		Categoria cat2 = new Categoria(null, "Escritório");
//
//		Produto p1 = new Produto(null, "Impressora", 800.00);
//		Produto p2 = new Produto(null, "Mouse", 300.00);
//		Produto p3 = new Produto(null, "Teclado", 150.00);
//
//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat2.getProdutos().addAll(Arrays.asList(p1));
//
//		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
//		p2.getCategorias().addAll(Arrays.asList(cat1));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
//
//		catRepo.saveAll(Arrays.asList(cat1, cat2));
//		prodRepo.saveAll(Arrays.asList(p1,p2,p3));



	}
}
