package com.project.srvcliente.controller;

import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.domain.dto.ResponseDTO;
import com.project.srvcliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.srvcliente.utils.Constantes.CADASTRADO_COM_SUCESSO;

@RestController
@RequestMapping("/erp/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    private ResponseDTO responseDTO;

    @PostMapping("/novoCliente")
    public ResponseEntity<ResponseDTO> novoCliente(@RequestBody ClienteDTO cliente) {
        responseDTO = service.salvar(cliente);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/buscaCliente/{cpf}")
    public ResponseEntity<ResponseDTO> getClienteCPF(@PathVariable String cpf) {
        responseDTO = service.buscaClienteCpf(cpf);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/editaCliente/{id}")
    public ResponseEntity<ResponseDTO> uptCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        responseDTO = service.atualiza(id, cliente);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/deletaCliente/{id}")
    public ResponseEntity<ResponseDTO> deletaCliente(@PathVariable Long id){
        responseDTO = service.deletaCliente(id);
        return ResponseEntity.ok(responseDTO);
    }

}
