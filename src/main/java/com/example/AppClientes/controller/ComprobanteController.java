package com.example.AppClientes.controller;

import java.util.List;

import com.example.AppClientes.entity.Comprobante;
import com.example.AppClientes.entity.ComprobanteDTO;
import com.example.AppClientes.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping
    public List<ComprobanteDTO> findAll() {
        return this.comprobanteService.findAll();
    }

    // Single item

    @GetMapping("/{id}")
    public ComprobanteDTO one(@PathVariable Integer id) {

        return this.comprobanteService.findById(id);
    }

    @PostMapping
    public ComprobanteDTO newEntity(@RequestBody Comprobante comprobante) {
        return this.comprobanteService.save(comprobante);
    }
}