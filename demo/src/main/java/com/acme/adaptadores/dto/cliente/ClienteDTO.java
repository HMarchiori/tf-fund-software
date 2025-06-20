package com.acme.adaptadores.dto.cliente;


import com.acme.adaptadores.dto.jogo.JogoEletronicoDTO;
import com.acme.adaptadores.dto.jogo.JogoMesaDTO;
import com.acme.dominio.modelo.cliente.ClienteEmpresarial;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo_cliente")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClienteIndividualDTO.class, name = "individual"),
        @JsonSubTypes.Type(value = ClienteEmpresarialDTO.class, name = "empresarial")
})
@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private int numero;
    private String nome;
    private String endereco;

    public ClienteDTO(int numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

}
