package com.acme.aplicacao.casos.lista;

import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_ListaJogos {

    public final IJogoRepositorio repositorio;

    public UC_ListaJogos(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Jogo> executarUC() {
        return repositorio.getJogos();
    }

}
