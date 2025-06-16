package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.jogo.Jogo;

import java.util.List;
import java.util.Optional;

public interface IJogoRepositorio {
    void salvar(Jogo jogo);
    List<Jogo> buscarTodos();
    List<Jogo> buscarPorCodigo(long codigo);
}
