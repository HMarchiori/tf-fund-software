package com.acme.aplicacao.casos;

import com.acme.adaptadores.dto.JogoDTO;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.persistencia.IJogoRepositorio;

import java.util.List;

public class UC_ListaJogos {
    public final IJogoRepositorio repositorio;

    public UC_ListaJogos(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Jogo> executar() {
        return repositorio.buscarTodos();
    }

}
