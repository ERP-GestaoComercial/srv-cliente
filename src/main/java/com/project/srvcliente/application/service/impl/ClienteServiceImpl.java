package com.project.srvcliente.application.service.impl;

import com.project.srvcliente.application.service.ClienteService;
import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.domain.dto.ComprasDTO;
import com.project.srvcliente.domain.dto.ResponseDTO;
import com.project.srvcliente.domain.exception.ClienteException;
import com.project.srvcliente.domain.model.Cliente;
import com.project.srvcliente.domain.repository.ClienteRepository;
import com.project.srvcliente.domain.service.ClienteDomainService;
import com.project.srvcliente.utils.Constants.Constantes;
import com.project.srvcliente.utils.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    private ClienteDomainService clienteDomainService;
    @Autowired
    ClienteMapper mapper;

    @Override
    public ResponseDTO salvar(ClienteDTO clienteDTO) {
        if (clienteDTO != null) {
            Cliente cliente = new Cliente();
            mapper.dtoToCliente(clienteDTO, cliente);
            clienteDomainService.validaDadosCliente(cliente);
            clienteRepository.save(cliente);
            return new ResponseDTO(Constantes.CADASTRADO_COM_SUCESSO);
        } else {
            throw new ClienteException(Constantes.ERRO_CADASTRADO);
        }
    }

    @Override
    public ResponseDTO buscaClienteCpf(String cpf) {
        if (cpf.isBlank()) {
            throw new ClienteException(Constantes.ERRO_ENCONTRADO);
        }
        Cliente cliente = clienteRepository.findClienteByCpf(cpf);
        return new ResponseDTO(Constantes.ENCONTRADO_COM_SUCESSO, cliente);
    }

    @Override
    public ResponseDTO atualiza(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ClienteException(Constantes.ERRO_ATUALIZAR);
        }
        mapper.dtoToCliente(clienteDTO, cliente);
        clienteRepository.save(cliente);
        return new ResponseDTO(Constantes.ATUALIZADO_COM_SUCESSO);
    }

    @Override
    public ResponseDTO deletaCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ClienteException(Constantes.ERRO_REMOVER);
        }
        clienteRepository.delete(cliente);
        return new ResponseDTO(Constantes.REMOVIDO_COM_SUCESSO);
    }

    @Override
    public ResponseDTO consultaCompras(String cpf) {
        if (cpf.isBlank()) throw new ClienteException(Constantes.ERRO_ENCONTRADO);

        Cliente cliente = clienteRepository.findClienteByCpf(cpf);
        if (cliente == null) throw new ClienteException(Constantes.ERRO_ENCONTRADO);

        List<ComprasDTO> listaCompras = clienteRepository.findComprasByCpf(cpf);

        return new ResponseDTO(Constantes.COMPRAS_CONSULTADAS, listaCompras);
    }

}
