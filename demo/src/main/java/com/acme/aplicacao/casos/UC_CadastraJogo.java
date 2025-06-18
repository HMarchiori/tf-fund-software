package com.acme.aplicacao.casos;

import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UC_CadastraJogo {

    public final IJogoRepositorio repositorio;

    public UC_CadastraJogo(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void executarUC(Jogo jogo) {
        repositorio.salvarJogo(jogo);
    }

}
