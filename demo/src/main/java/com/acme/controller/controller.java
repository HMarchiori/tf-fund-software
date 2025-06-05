package com.acme.controller;
import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.acme.ENTITY.ECliente;
import com.acme.ENTITY.Eindividual;
import com.acme.JPA.clienteRepository;
import com.acme.JPA.individualRepository;

@RestController
@RequestMapping("/api")
public class controller {
    private final clienteRepository clienteRepo;
    private final individualRepository individualRepo;

    public controller(clienteRepository clienteRepo, individualRepository individualRepo) {
        this.individualRepo = individualRepo;
        this.clienteRepo = clienteRepo;
    }

     @GetMapping("/listarclientes")
       public List<ECliente> getClientes() {
            return clienteRepo.findAll();

        }

        @CrossOrigin(origins = "*")
        @PostMapping("/cadastro")
        public ECliente cadastrarcliente(@RequestBody ECliente ecliente){
            Eindividual eindividual = ecliente.getIndividual();

            if (eindividual != null && !individualRepo.existsById(eindividual.getCpf())) {
                individualRepo.save(eindividual);
             }
            return clienteRepo.save(ecliente);
        }


}
