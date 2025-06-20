package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.aluguel.EAluguel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAluguelJpaRepository extends CrudRepository<EAluguel, Integer> {
    List<EAluguel> findAll();
    EAluguel findByIdentificador(Integer identificador);
    EAluguel save(EAluguel aluguel);
    List<EAluguel> findAllByClienteNumero(Integer numero);
    List<EAluguel> findAllByJogoCodigo(Integer codigo);

}
