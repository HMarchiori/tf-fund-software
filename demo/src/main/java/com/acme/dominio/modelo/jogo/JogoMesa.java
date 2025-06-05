package com.acme.dominio.modelo.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoMesa extends Jogo {
    public TipoMesa tipo;
    public int numeroPecas;

    public JogoMesa(TipoMesa tipo, int numeroPecas) {
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }
}
