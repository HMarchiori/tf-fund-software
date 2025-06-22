package com.acme.aplicacao.casos.aluguel;

import java.util.List;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UC_Aluguel{

    private final IAluguelRepositorio aluguelRepositorio;

    @Autowired
    public UC_Aluguel(IAluguelRepositorio aluguelRepositorio) {
        this.aluguelRepositorio = aluguelRepositorio;
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        aluguelRepositorio.cadastrar(aluguel);
    }

    public Aluguel obterPorId(Integer id) {
        return aluguelRepositorio.porId(id);
    }

    public List<Aluguel> listarAlugueis() {
        return aluguelRepositorio.todos();
    }
}