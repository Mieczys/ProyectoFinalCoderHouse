package com.example.AppClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppClientes.entity.Cliente;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
