package com.acme.adaptadores.dto.jogo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "dtype")
@JsonSubTypes({
        @JsonSubTypes.Type(value = JogoMesaDTO.class, name = "mesa"),
        @JsonSubTypes.Type(value = JogoEletronicoDTO.class, name = "eletronico")
})
// precisamos usar este querido para o POST funcionar corretamente
// um pouco exagerado? maybe. Porém funciona.
public abstract class JogoDTO {
    protected Integer codigo;
    protected String nome;
    protected double valorBase;

    public JogoDTO(Integer codigo, String nome, double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }

}