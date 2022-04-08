package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ItemOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private final ItemOrderPK id = new ItemOrderPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public ItemOrder() {
    }

    public ItemOrder(final ClientOrder clientOrder, final Product product, final Double discount, final Integer quantity, final Double price) {

        super();
        id.setOrder(clientOrder);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public ClientOrder getOrder() {
        return id.getOrder();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public ItemOrderPK getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(final Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }
}