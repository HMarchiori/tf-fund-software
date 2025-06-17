package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.jogo.Jogo;
import org.springframework.stereotype.Component;

import java.util.List;

// temporário!!
@Component
public interface IJogoRepositorio {
    void cadastrar(Jogo jogo);
    List<Jogo> buscarTodos();
    List<Jogo> buscarPorCodigo(int codigo);
}
