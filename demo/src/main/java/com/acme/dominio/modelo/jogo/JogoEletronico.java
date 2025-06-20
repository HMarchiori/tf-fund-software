package com.acme.dominio.modelo.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoEletronico extends Jogo {
    public TipoEletronico tipo;
    public String plataforma;

    public JogoEletronico(int codigo, String nome, double valorBase, TipoEletronico tipo, String plataforma) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }
}
