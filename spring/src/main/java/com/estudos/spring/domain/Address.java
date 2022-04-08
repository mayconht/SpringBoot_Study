package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String number;
    private String complement;
    private String district;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Address() {
    }

    public Address(final Integer id, final String street, final String number, final String complement, final String district, final String zipCode, final Client client, final City city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zipCode = zipCode;
        this.client = client;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(final String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public City getCity() {
        return city;
    }

    public void setCity(final City city) {
        this.city = city;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        final Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
