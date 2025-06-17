package com.acme.adaptadores.dto.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JogoEletronicoDTO extends JogoDTO {
    protected TipoEletronico tipo;
    protected String plataforma;

    public JogoEletronicoDTO(int codigo, String nome, double valorBase, TipoEletronico tipo, String plataforma) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }
}