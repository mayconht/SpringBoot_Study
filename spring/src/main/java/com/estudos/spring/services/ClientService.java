package com.estudos.spring.services;

import com.estudos.spring.domain.Client;
import com.estudos.spring.repositories.ClientRepository;
import com.estudos.spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client find(final Integer id) {
        final Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Client not found: " + id + "Typo: " + Client.class.getName()));
    }
}
