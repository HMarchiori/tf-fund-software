package com.acme.dominio.persistencia;

import java.util.*;

import com.acme.dominio.modelo.cliente.Cliente;

public interface IClienteRepositorio {
    List<Cliente> FindAll();
    Cliente FindById(Integer id);
    void Save(Cliente cliente);

}
