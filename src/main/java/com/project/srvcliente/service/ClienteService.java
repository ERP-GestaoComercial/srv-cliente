package com.project.srvcliente.service;

import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.domain.dto.ResponseDTO;
import com.project.srvcliente.model.Cliente;
import com.project.srvcliente.repository.ClienteRepository;
import com.project.srvcliente.utils.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.srvcliente.utils.Constantes.*;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;
    @Autowired
    ClienteMapper mapper;

    public ResponseDTO salvar(ClienteDTO clienteDTO) {
        if (clienteDTO != null) {
            Cliente cliente = new Cliente();
            mapper.dtoToCliente(clienteDTO, cliente);
            repository.save(cliente);
            return new ResponseDTO(CADASTRADO_COM_SUCESSO);
        } else {
            return new ResponseDTO(ERRO_CADASTRADO);
        }

    }

    public ResponseDTO buscaClienteCpf(String cpf) {
        if (!cpf.isBlank()) {
            Cliente cliente = repository.findByCpf(cpf);
            return new ResponseDTO(ENCONTRADO_COM_SUCESSO, cliente);
        } else {
            return new ResponseDTO(ERRO_ENCONTRADO);
        }
    }

    public ResponseDTO atualiza(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente != null) {
            mapper.dtoToCliente(clienteDTO, cliente);
            repository.save(cliente);
            return new ResponseDTO(ATUALIZADO_COM_SUCESSO);
        } else {
            return new ResponseDTO(ERRO_ATUALIZAR);
        }
    }

    public ResponseDTO deletaCliente(Long id){
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente != null){
            repository.delete(cliente);
            return new ResponseDTO(REMOVIDO_COM_SUCESSO);
        } else {
            return new ResponseDTO(ERRO_REMOVER);
        }
    }
}
