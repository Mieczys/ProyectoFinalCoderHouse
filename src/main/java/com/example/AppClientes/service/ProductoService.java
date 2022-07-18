package com.example.AppClientes.service;

import com.example.AppClientes.entity.Producto;
import com.example.AppClientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Producto Service
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    public Producto save(Producto cliente) {
        return this.productoRepository.save(cliente);
    }

    public Producto findById(Integer id) {

        var opCliente =  this.productoRepository.findById(id);
        if (opCliente.isPresent()) {
            return opCliente.get();
        } else {
            return new Producto();
        }
    }

}
