package com.project.srvcliente.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private String mensagem;
    private Object object;
    @JsonProperty(value = "lista")
    private List<Object> listaObject;

    public ResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ResponseDTO(String mensagem, Object object) {
        this.mensagem = mensagem;
        this.object = object;
    }

    public ResponseDTO(String mensagem, List<Object> listaObject) {
        this.mensagem = mensagem;
        this.listaObject = listaObject;
    }
}
