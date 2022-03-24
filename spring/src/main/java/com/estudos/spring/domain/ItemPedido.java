package com.estudos.spring.domain;

import java.io.Serializable;
import java.util.Objects;

public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;


    private ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        itemPedidoPK.setPedido(pedido);
        itemPedidoPK.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return itemPedidoPK.getPedido();
    }

    public Produto getProduto() {
        return itemPedidoPK.getProduto();
    }

    public ItemPedidoPK getItemPedidoPK() {
        return itemPedidoPK;
    }

    public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
        this.itemPedidoPK = itemPedidoPK;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return itemPedidoPK.equals(that.itemPedidoPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemPedidoPK);
    }
}
