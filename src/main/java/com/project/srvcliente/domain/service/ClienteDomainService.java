package com.project.srvcliente.domain.service;

import com.project.srvcliente.domain.exception.ClienteException;
import com.project.srvcliente.domain.model.Cliente;

public interface ClienteDomainService {

    void validaDadosCliente(Cliente cliente) throws ClienteException;

}
