package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class State implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String federativeUnit;

    @OneToMany(mappedBy = "state") // da classe cidade que faz o mapeamento principal.
    private List<City> cities;

    public State() {
    }

    public State(final Integer id, final String name, final String federativeUnit) {
        this.id = id;
        this.name = name;
        this.federativeUnit = federativeUnit;
    }

    public String getFederativeUnit() {
        return federativeUnit;
    }

    public void setFederativeUnit(final String federativeUnit) {
        this.federativeUnit = federativeUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<City> getCidades() {
        return cities;
    }

    public void setCidades(final List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        final State state = (State) o;
        return id.equals(state.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
