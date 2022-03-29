package com.estudos.spring.services;

import com.estudos.spring.domain.Order;
import com.estudos.spring.repositories.OrderRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired // Injeção de Dependencia, não há necessidade de instanciar. (inversão de controle)
    private OrderRepository repo;

    public Order find(Integer id) {
        Optional<Order> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Order não encontrada: " + id + ", Tipo: " + Order.class.getName()));
    }
}
