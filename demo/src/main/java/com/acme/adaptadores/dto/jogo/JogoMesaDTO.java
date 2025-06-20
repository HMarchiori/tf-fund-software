package com.acme.adaptadores.dto.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JogoMesaDTO extends JogoDTO {
    protected TipoMesa tipo;
    protected int numeroPecas;

    public JogoMesaDTO(int codigo, String nome, double valorBase, TipoMesa tipo, int numeroPecas) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }
}
