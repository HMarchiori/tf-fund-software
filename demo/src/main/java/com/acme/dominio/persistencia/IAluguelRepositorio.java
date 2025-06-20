package com.acme.dominio.persistencia;

import com.acme.dominio.modelo.aluguel.Aluguel;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IAluguelRepositorio {
    List<Aluguel> getAlugueis();
    Aluguel getAluguelByIdentificador(Integer id);
    void salvarAluguel(Aluguel aluguel);
    boolean existeAluguelPorIdentificador(Integer id);
    List<Aluguel> getAlugueisPorCliente(Integer numero);
    List<Aluguel> getAlugueisPorJogo(Integer codigo);

}
