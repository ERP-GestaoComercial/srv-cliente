package com.project.srvcliente.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Compras {

    private Long id;
    private String cpf;
    private String produto;
    private BigDecimal valor;
    private int quantidade;
    private Date dtCompra;
}
