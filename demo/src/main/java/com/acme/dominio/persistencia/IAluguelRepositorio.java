package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.aluguel.Aluguel;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IAluguelRepositorio {
    List<Aluguel> todos();
    Aluguel porId(String id);
    void cadastrar(Aluguel aluguel);
}
