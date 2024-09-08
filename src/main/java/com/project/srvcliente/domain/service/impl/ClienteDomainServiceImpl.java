package com.project.srvcliente.domain.service.impl;

import com.project.srvcliente.domain.exception.ClienteException;
import com.project.srvcliente.domain.model.Cliente;
import com.project.srvcliente.domain.service.ClienteDomainService;

public class ClienteDomainServiceImpl implements ClienteDomainService {

    @Override
    public void validaDadosCliente(Cliente cliente) throws ClienteException {
        cliente.validarNome();
        cliente.validarSobrenome();
        cliente.validarTelefone();
        cliente.validarEndereco();
        cliente.validarCpf();
    }

}
