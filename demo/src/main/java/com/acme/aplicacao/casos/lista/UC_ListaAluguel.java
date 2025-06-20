package com.acme.aplicacao.casos.lista;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_ListaAluguel {

    public final IAluguelRepositorio repositorio;

    public UC_ListaAluguel(IAluguelRepositorio iAluguelRepositorio)  {
        this.repositorio = iAluguelRepositorio;
    }

    public List<Aluguel> executarUC() {
        return repositorio.getAlugueis();
    }

}
