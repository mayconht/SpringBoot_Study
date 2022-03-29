package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TicketPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Date dueDate;
    private Date paymentDate;


    public TicketPayment(Date dueDate, Date paymentDate) {
        super();
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public TicketPayment(Integer id, PaymentStatus status, Order order, Date dueDate, Date paymentDate) {
        super(id, status, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public TicketPayment() {

    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
