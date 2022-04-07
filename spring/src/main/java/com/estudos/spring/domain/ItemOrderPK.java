package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemOrderPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    public ClientOrder getOrder() {
        return clientOrder;
    }

    public void setOrder(final ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientOrder == null) ? 0 : clientOrder.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemOrderPK other = (ItemOrderPK) obj;
        if (clientOrder == null) {
            if (other.clientOrder != null) {
                return false;
            }
        } else if (!clientOrder.equals(other.clientOrder)) {
            return false;
        }
        if (product == null) {
            return other.product == null;
        } else {
            return product.equals(other.product);
        }
    }


}