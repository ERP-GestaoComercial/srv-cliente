package com.project.srvcliente.model;

import lombok.Data;

@Data

public class Endereco {

    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private int cep;
    private String cidade;
    private String estado;
    private String pais;
}
