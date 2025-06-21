package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.aluguel.Aluguel;

import java.util.List;

public interface IAluguelRepositorio {

    void cadastrar(Aluguel aluguel);
    List<Aluguel> todos();
    Aluguel porId(Integer id);
}
