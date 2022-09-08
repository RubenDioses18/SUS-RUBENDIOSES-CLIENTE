package com.idat.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.cliente.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
}
