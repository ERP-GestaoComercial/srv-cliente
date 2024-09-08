package com.project.srvcliente.infrastructure.adapter.input;

import com.project.srvcliente.application.service.ClienteService;
import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.domain.dto.ResponseDTO;
import com.project.srvcliente.application.service.impl.ClienteServiceImpl;
import com.project.srvcliente.domain.exception.ClienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/erp/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    private ResponseDTO responseDTO;

    @PostMapping("/novoCliente")
    public ResponseEntity<ResponseDTO> novoCliente(@RequestBody ClienteDTO clienteDTO) throws ClienteException {
        responseDTO = service.salvar(clienteDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/buscaCliente/{cpf}")
    public ResponseEntity<ResponseDTO> getClienteCPF(@PathVariable String cpf) throws ClienteException{
        responseDTO = service.buscaClienteCpf(cpf);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/editaCliente/{id}")
    public ResponseEntity<ResponseDTO> uptCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) throws ClienteException{
        responseDTO = service.atualiza(id, cliente);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/deletaCliente/{id}")
    public ResponseEntity<ResponseDTO> deletaCliente(@PathVariable Long id) throws ClienteException{
        responseDTO = service.deletaCliente(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/consultaCompras/{cpf}")
    public ResponseEntity<ResponseDTO> consultaCompras(@PathVariable String cpf){
        responseDTO = service.consultaCompras(cpf);
        return ResponseEntity.ok(responseDTO);
    }
}
