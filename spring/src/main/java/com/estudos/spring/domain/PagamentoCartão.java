package com.estudos.spring.domain;

import com.estudos.spring.domain.enums.EstadoPagamento;

import java.util.Date;

public class PagamentoCartão extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoCartão() {
    }

    public PagamentoCartão(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoCartão(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }


}
