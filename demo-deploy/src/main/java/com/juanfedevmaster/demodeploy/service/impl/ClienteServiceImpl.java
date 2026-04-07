package com.juanfedevmaster.demodeploy.service.impl;

import com.juanfedevmaster.demodeploy.exception.ClienteNotFoundException;
import com.juanfedevmaster.demodeploy.model.Cliente;
import com.juanfedevmaster.demodeploy.repository.ClienteRepository;
import com.juanfedevmaster.demodeploy.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificar(Long id, Cliente cliente) {
        return clienteRepository.update(id, cliente)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Override
    public void eliminar(Long id) {
        if (!clienteRepository.deleteById(id)) {
            throw new ClienteNotFoundException(id);
        }
    }
}
