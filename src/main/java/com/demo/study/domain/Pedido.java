//package com.demo.study.domain;
//
//import java.util.Date;
//import java.util.Objects;
//
//public class Pedido {
//    private Integer id;
//    private Date date;
//
//    public Pedido(Integer id, Date date) {
//        this.id = id;
//        this.date = date;
//    }
//
//    public Pedido(){
//
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pedido pedido = (Pedido) o;
//        return id.equals(pedido.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
