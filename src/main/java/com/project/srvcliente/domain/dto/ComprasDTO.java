package com.project.srvcliente.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ComprasDTO {

    private Long id;
    private String produto;
    private BigDecimal valor;
    private int quantidade;
}
