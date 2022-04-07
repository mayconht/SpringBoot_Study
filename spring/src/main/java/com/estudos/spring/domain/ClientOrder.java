package com.estudos.spring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClientOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date moment;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "deliveryAddress_id")
    private Address deliveryAddress;

    @OneToMany(mappedBy = "id.order_id.id")
    private Set<ItemOrder> items = new HashSet<>();

    public ClientOrder() {
    }

    public ClientOrder(final Integer id, final Date moment, final Client client, final Address deliveryAddress) {
        super();
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(final Date moment) {
        this.moment = moment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(final Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(final Address addressDeEntrega) {
        this.deliveryAddress = addressDeEntrega;
    }

    public Set<ItemOrder> getItems() {
        return items;
    }

    public void setItems(final Set<ItemOrder> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        final ClientOrder other = (ClientOrder) obj;
        if (id == null) {
            return other.id == null;
        } else {
            return id.equals(other.id);
        }
    }


}