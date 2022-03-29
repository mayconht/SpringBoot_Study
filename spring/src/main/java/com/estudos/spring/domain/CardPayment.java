package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class CardPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer installmentNumber;

    public CardPayment() {
    }

    public CardPayment(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public CardPayment(Integer id, EstadoPagamento state, Order orders, Integer installmentNumber) {
        super(id, state, orders);
        this.installmentNumber = installmentNumber;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }


}
