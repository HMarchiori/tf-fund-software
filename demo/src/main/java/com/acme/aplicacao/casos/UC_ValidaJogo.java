package com.acme.aplicacao.casos;

import com.acme.dominio.persistencia.IJogoRepositorio;

public class UC_ValidaJogo {
    private final IJogoRepositorio repositorio;

    public UC_ValidaJogo(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public boolean executar(int codigo) {

        if (codigo <= 0) {
            return false;
        }

        var jogos = repositorio.buscarPorCodigo(codigo);

        if (jogos.isEmpty()) {
            return false;
        }

        var jogo = jogos.get(0);
        return jogo != null && jogo.getCodigo() == codigo;
    }
}
