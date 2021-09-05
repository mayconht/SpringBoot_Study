package com.demo.study;

import com.demo.study.domain.Categoria;
import com.demo.study.domain.Produto;
import com.demo.study.repositories.CategoriaRepository;
import com.demo.study.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StartPointSBTests {

	@Autowired private CategoriaRepository categoriaRepository;
	@Autowired private ProdutoRepository produtoRepository;
	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;



	@Test
	void injectedComponentsAreNotNull(){
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(categoriaRepository);
		assertNotNull(categoriaRepository);
	}

	@Test
 	void databaseInsertDataTest() {
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
