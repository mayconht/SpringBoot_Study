package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class CardPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer installmentNumber;

    public CardPayment() {
    }

    public CardPayment(final Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public CardPayment(final Integer id, final PaymentStatus state, final Order orders, final Integer installmentNumber) {
        super(id, state, orders);
        this.installmentNumber = installmentNumber;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(final Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }


}
