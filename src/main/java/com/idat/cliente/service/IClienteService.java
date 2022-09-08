package com.idat.cliente.service;

import java.util.List;

import com.idat.cliente.model.Cliente;

public interface IClienteService {
    public void guardar(Cliente cliente);
    public void editar(Cliente cliente);
    public void eliminar(int id);
    public List<Cliente> listar();
    public Cliente buscar(int id);
    
}
