package com.acme.controller;
import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.acme.ENTITY.ECliente;
import com.acme.ENTITY.EEmpresarial;
import com.acme.ENTITY.Eindividual;
import com.acme.JPA.clienteRepository;
import com.acme.JPA.empresarialRepository;
import com.acme.JPA.individualRepository;

@RestController
@RequestMapping("/acmegames/cadastro")
public class controller {
    private final clienteRepository clienteRepo;
    private final individualRepository individualRepo;
    private final empresarialRepository empresarialRepo;

    public controller(clienteRepository clienteRepo, individualRepository individualRepo, empresarialRepository empresarialRepo) {
        this.individualRepo = individualRepo;
        this.clienteRepo = clienteRepo;
        this.empresarialRepo = empresarialRepo; 
    }

     @GetMapping("/listacliente")
       public List<ECliente> getClientes() {
            return clienteRepo.findAll();

        }

        @CrossOrigin(origins = "*")
        @PostMapping("cadcliente")
        public ECliente cadastrarcliente(@RequestBody ECliente ecliente){
            Eindividual eindividual = ecliente.getIndividual();
            EEmpresarial eempresarial = ecliente.getEmpresarial();

            if (eempresarial != null && !empresarialRepo.existsById(eempresarial.getCnpj())) {
                empresarialRepo.save(eempresarial);
            }

            if (eindividual != null && !individualRepo.existsById(eindividual.getCpf())) {
                individualRepo.save(eindividual);
             }
            return clienteRepo.save(ecliente);
        }


}
