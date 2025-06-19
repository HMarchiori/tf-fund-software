package com.acme.dominio.persistencia;

import java.util.*;

import com.acme.dominio.modelo.cliente.Cliente;

public interface IClienteRepositorio {
    // mudei um pouco aqui para não conflitar com o nome do método
    // do repo JPA! E padronizar

    // por enquanto vamos deixar esses queridos assim
    // SE QUISERMOS COLOCAR MAIS MÉTODOS,

    // PASSO 1: Implementamos aqui
    // PASSO 2: Vemos se o CRUD que já temos no JPA dá conta
    // PASSO 3: Implementamos o metodo daqui no REPO DO FRAMEWORK.
    // PASSO 4: Criamos caso de uso chamando ESSES MÉTODOS DAQUI.
    // A IMPLEMENTAÇÃO DESTA INTERFACE ESTÁ NA ABA FRAMEWORK.

    List<Cliente> getClientes();
    Cliente getClienteByNumero(Integer id);
    void salvarCliente(Cliente cliente);
    boolean existeClientePorNumero(Integer id);

}
