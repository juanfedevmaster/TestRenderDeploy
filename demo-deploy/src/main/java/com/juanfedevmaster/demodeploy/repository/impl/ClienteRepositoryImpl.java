package com.juanfedevmaster.demodeploy.repository.impl;

import com.juanfedevmaster.demodeploy.model.Cliente;
import com.juanfedevmaster.demodeploy.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final Map<Long, Cliente> almacen = new ConcurrentHashMap<>();
    private final AtomicLong secuencia = new AtomicLong(1);

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(almacen.values());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return Optional.ofNullable(almacen.get(id));
    }

    @Override
    public Cliente save(Cliente cliente) {
        long nuevoId = secuencia.getAndIncrement();
        cliente.setId(nuevoId);
        almacen.put(nuevoId, cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> update(Long id, Cliente cliente) {
        if (!almacen.containsKey(id)) {
            return Optional.empty();
        }
        cliente.setId(id);
        almacen.put(id, cliente);
        return Optional.of(cliente);
    }

    @Override
    public boolean deleteById(Long id) {
        return almacen.remove(id) != null;
    }
}
