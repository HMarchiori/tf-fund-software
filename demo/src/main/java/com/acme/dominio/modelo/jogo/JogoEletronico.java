package com.acme.dominio.modelo.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoEletronico extends Jogo {
    public TipoEletronico tipo;
    public String plataforma;

    public JogoEletronico(TipoEletronico tipo, String plataforma) {
        this.tipo = tipo;
        this.plataforma = plataforma;
    }
}
