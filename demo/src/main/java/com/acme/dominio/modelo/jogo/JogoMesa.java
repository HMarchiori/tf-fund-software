package com.acme.dominio.modelo.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoMesa extends Jogo {
    private TipoMesa tipo;
    private int numeroPecas;

    public JogoMesa(int codigo, String nome, double valorBase, TipoMesa tipo, int numeroPecas) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }
}
