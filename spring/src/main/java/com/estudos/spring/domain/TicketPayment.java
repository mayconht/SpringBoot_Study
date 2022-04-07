package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TicketPayment extends Payment {
    private static final long serialVersionUID = 1L;

    private Date dueDate;
    private Date paymentDate;


    public TicketPayment(final Date dueDate, final Date paymentDate) {
        super();
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public TicketPayment(final Integer id, final PaymentStatus status, final ClientOrder clientOrder, final Date dueDate, final Date paymentDate) {
        super(id, status, clientOrder);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public TicketPayment() {

    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(final Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
