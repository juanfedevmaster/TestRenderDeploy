package com.juanfedevmaster.demodeploy.repository;

import com.juanfedevmaster.demodeploy.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    Optional<Cliente> update(Long id, Cliente cliente);

    boolean deleteById(Long id);
}
