package com.project.srvcliente.application.service;

import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.domain.dto.ComprasDTO;
import com.project.srvcliente.domain.dto.ResponseDTO;
import com.project.srvcliente.domain.exception.ClienteException;

import java.util.List;

public interface ClienteService {

    ResponseDTO salvar(ClienteDTO clienteDTO) throws ClienteException;

    ResponseDTO buscaClienteCpf(String cpf) throws ClienteException;

    ResponseDTO atualiza(Long id, ClienteDTO clienteDTO) throws ClienteException;

    ResponseDTO deletaCliente(Long id) throws ClienteException;

    ResponseDTO consultaCompras(String cpf);
}
