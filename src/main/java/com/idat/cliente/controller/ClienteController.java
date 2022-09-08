package com.idat.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.cliente.model.Cliente;
import com.idat.cliente.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = service.listar();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Cliente Cliente) {
        try {
            service.guardar(Cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> editar(@PathVariable("id") int id, @RequestBody Cliente Cliente) {
        try {
           service.editar(Cliente);
           return new ResponseEntity<Cliente>(HttpStatus.OK); 
        } catch (Exception e) {
        return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST); 
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            service.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
