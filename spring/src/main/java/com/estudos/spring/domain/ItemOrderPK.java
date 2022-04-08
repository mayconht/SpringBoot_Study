package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemOrderPK implements Serializable {
    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private ClientOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @JsonIgnore
    public ClientOrder getOrder() {
        return order;
    }

    public void setOrder(final ClientOrder order) {
        this.order = order;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemOrderPK)) {
            return false;
        }
        final ItemOrderPK that = (ItemOrderPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}