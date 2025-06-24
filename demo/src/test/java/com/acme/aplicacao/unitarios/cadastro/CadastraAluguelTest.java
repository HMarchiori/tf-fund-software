package com.acme.aplicacao.unitarios.cadastro;

import com.acme.aplicacao.casos.cadastro.UC_CadastraAluguel;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CadastraAluguelTest {

    private final IAluguelRepositorio aluguelRepositorio = Mockito.mock(IAluguelRepositorio.class);
    private final UC_CadastraAluguel service = new UC_CadastraAluguel(aluguelRepositorio);



    @Test
    void testCadastraAluguelValido() {
    
        JogoEletronico jogo = new JogoEletronico(1, "FIFA 21", 150.0, TipoEletronico.ESTRATEGIA, "PS4");
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua B, 456", "987.654.321-00");
        Aluguel aluguel = new Aluguel(1, new Date(), 5, jogo, cliente);
        
        service.executarUC(aluguel);
        
        assertNotNull(aluguel);
        assertEquals(1, aluguel.getIdentificador());
        assertEquals(jogo, aluguel.getJogo());
        assertEquals(cliente, aluguel.getCliente());
    }

}