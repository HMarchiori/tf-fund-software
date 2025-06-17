package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.jogo.Jogo;


import java.util.List;
import java.util.Optional;


public interface IJogoRepositorio {
    void cadastrar(Jogo jogo);
    List<Jogo> buscarTodos();
    Optional<Jogo> buscarPorCodigo(int codigo);
    boolean existsByCodigo(int codigo);
}
