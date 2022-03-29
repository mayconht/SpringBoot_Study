package com.estudos.spring.services;

import com.estudos.spring.domain.Client;
import com.estudos.spring.repositories.ClienteRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Client find(Integer id) {
        Optional<Client> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Client não encontrado: " + id + "Tipo: " + Client.class.getName()));
    }
}
