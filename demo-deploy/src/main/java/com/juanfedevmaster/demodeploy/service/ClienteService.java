package com.juanfedevmaster.demodeploy.service;

import com.juanfedevmaster.demodeploy.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> obtenerTodos();

    Cliente obtenerPorId(Long id);

    Cliente crear(Cliente cliente);

    Cliente modificar(Long id, Cliente cliente);

    void eliminar(Long id);
}
