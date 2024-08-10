package com.project.srvcliente.domain.dto;

import com.project.srvcliente.model.Endereco;
import lombok.Data;

@Data
public class ClienteDTO {

    private String nome;
    private String sobreNome;
    private int cpf;
    private int telefone;
    private Endereco endereco;
}
