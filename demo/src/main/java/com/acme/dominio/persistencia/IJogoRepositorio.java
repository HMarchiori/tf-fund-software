package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.jogo.Jogo;


import java.util.List;
import java.util.Optional;


public interface IJogoRepositorio {
    List<Jogo> getJogos();
    Jogo getJogoPorId(Integer id);
    boolean existeJogoPorId(Integer id);
    void salvarJogo(Jogo jogo);
}
