package com.example.AppClientes.repository;

import com.example.AppClientes.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
