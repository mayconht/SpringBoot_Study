package com.demo.study.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/*
 * Aqui é declarado como entidade que sera usada em comunicação/geração de query e criação dos objetos
 * para manipulação posterior das classes.
 *
 * */

@Entity
public class Categoria implements Serializable {
    /*
     * implements Serializable define que os dados poderão ser gravados em arquivo (Json por exemplo)
     * o que facilita no futuro lidar com esses dados em uma API.
     * */
    private static final long serialVersionUID = 1L;

    /*
     * Notação de banco que indica que essa é a chave primaria e é um valor gerado pelo banco.
     *
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    //TODO - Revisar aqui sobre Many to Many
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    /*Hash code e equals permite verificar se o objeto é identico levando em conta a existencia do hash
     * de forma a definir se é exatamente o msm obj ou não.
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getId(), categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
