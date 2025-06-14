package com.acme.COMMANDLINNERRUNNER;

import com.acme.ENTITY.*;
import com.acme.enumerates.tipoEletronico;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.acme.JPA.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final clienteRepository clienteRepository;
    private final jogoRepository jogoRepository;
    private final individualRepository individualRepository; // Adicionado

    // Construtor com injeção de dependência para todos os repositórios
    public DataInitializer(clienteRepository clienteRepository, jogoRepository jogoRepository, individualRepository individualRepository) {
        this.clienteRepository = clienteRepository;
        this.jogoRepository = jogoRepository;
        this.individualRepository = individualRepository; // Inicializando
    }

    @Override
    public void run(String... args) throws Exception {
        // Criando o cliente
        Eindividual individual = new Eindividual("12345678900");
        ECliente cliente = new ECliente();
        cliente.setNome("João Silva");
        cliente.setEndereco("Rua Exemplo, 123");
        cliente.setIndividual(individual);

        // Salvando o Eindividual no banco
        individualRepository.save(individual);  // Agora isso está correto

        // Salvando o cliente no banco
        clienteRepository.save(cliente);

        // Criando o jogo eletrônico
        EjogoEletronico jogoEletronico = new EjogoEletronico();
        jogoEletronico.setNome("Super Aventura");
        jogoEletronico.setValorBase(99.99);
        jogoEletronico.setTipo(tipoEletronico.AVENTURA);
        jogoEletronico.setPlataforma("PlayStation");

        // Salvando o jogo no banco
        jogoRepository.save(jogoEletronico);
    }
}
