package com.idat.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.cliente.model.Cliente;
import com.idat.cliente.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public void guardar(Cliente cliente) {
        // TODO Auto-generated method stub
        repository.save(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        // TODO Auto-generated method stub
        repository.saveAndFlush(cliente);
    }

    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<Cliente> listar() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Cliente buscar(int id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }
    
}
