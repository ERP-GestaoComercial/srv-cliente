package com.project.srvcliente.domain.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private String nome;
    private String sobreNome;
    private int cpf;
    private int telefone;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private int cep;
    private String cidade;
    private String estado;
    private String pais;
}
