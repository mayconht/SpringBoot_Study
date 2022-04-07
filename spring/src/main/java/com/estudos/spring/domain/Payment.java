package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Herança
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private Integer id;
    private Integer status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    private ClientOrder clientOrder;

    public Payment() {
    }

    public Payment(final Integer id, final PaymentStatus status, final ClientOrder clientOrder) {
        super();
        this.id = id;
        this.status = status.getCod();
        this.clientOrder = clientOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(status);
    }

    public void setStatus(final PaymentStatus status) {
        this.status = status.getCod();
    }

    public ClientOrder getOrder() {
        return clientOrder;
    }

    public void setOrder(final ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Payment)) {
            return false;
        }
        final Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
