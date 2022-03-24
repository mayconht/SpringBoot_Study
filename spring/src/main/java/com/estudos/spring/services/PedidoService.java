package com.estudos.spring.services;

import com.estudos.spring.domain.Pedido;
import com.estudos.spring.repositories.PedidoRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired // Injeção de Dependencia, não há necessidade de instanciar. (inversão de controle)
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrada: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
