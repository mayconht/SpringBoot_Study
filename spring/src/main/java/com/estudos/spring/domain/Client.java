package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String cpfOrCnpj;
    private Integer type; // Atenção aos getters e setters.


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    //implementação sem dominio para conexão fraca entre objetos 1 pra muitos.
    @ElementCollection
    @CollectionTable(name = "PHONE")
    private Set<String> phone = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<ClientOrder> clientOrders = new ArrayList<>();

    public Client() {
    }

    public Client(final Integer id, final String name, final String email, final String cpfOrCnpj, final ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.type = type.getCod();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(final String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    //Usando a função ClientType para verificação
    public ClientType getType() {
        return ClientType.toEnum(type);
    }

    //Armazenando Tipo Inteiro.
    public void setType(final ClientType type) {
        this.type = type.getCod();
    }

    public void setType(final Integer type) {
        this.type = type;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(final List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(final Set<String> phone) {
        this.phone = phone;
    }

    public List<ClientOrder> getOrders() {
        return clientOrders;
    }

    public void setOrders(final List<ClientOrder> clientOrders) {
        this.clientOrders = clientOrders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        final Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
