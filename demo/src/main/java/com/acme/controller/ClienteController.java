package com.acme.controller;

import com.acme.domain.ECliente;
import com.acme.infraestrutura.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ClienteController {

    @Autowired
    private clienteRepository clienteRepository;

    @GetMapping("/listaclientes")
    public List<ECliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
