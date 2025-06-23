package com.acme.adaptadores.dto.aluguel;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AluguelDTO {
    private int identificador;
    private Date dataInicial;
    private int periodo;
    private JogoDTO jogo;
    private ClienteDTO cliente;

    public AluguelDTO(int identificador, Date dataInicial, int periodo, JogoDTO jogo, ClienteDTO cliente) {
        this.identificador = identificador;
        this.dataInicial = dataInicial;
        this.periodo = periodo;
        this.jogo = jogo;
        this.cliente = cliente;
    }

    public void setCodigo(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCodigo'");
    }

    public void setNumero(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumero'");
    }
}