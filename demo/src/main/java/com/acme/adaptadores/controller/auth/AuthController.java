package com.acme.adaptadores.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.persistencia.IClienteRepositorio;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IClienteRepositorio clienteRepositorio;

    @CrossOrigin(origins = "*")
   @PostMapping("/login")
    public ResponseEntity<ClienteDTO> login(@RequestBody Map<String, String> body) {
    String cpf = body.get("cpf");

    Cliente cliente = clienteRepositorio.buscarPorCpf(cpf);
    if (cliente == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);  
    return ResponseEntity.ok(clienteDTO);
}
}
