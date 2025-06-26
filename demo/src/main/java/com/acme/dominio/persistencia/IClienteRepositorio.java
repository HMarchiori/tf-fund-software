package com.acme.dominio.persistencia;

import java.util.*;

import com.acme.dominio.modelo.cliente.Cliente;

public interface IClienteRepositorio {
    Cliente buscarPorCpf(String cpf);
    List<Cliente> getClientes();
    Cliente getClienteByNumero(Integer id);
    void salvarCliente(Cliente cliente);
    boolean existeClientePorNumero(Integer id);

}
