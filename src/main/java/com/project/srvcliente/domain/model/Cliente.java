package com.project.srvcliente.domain.model;

import com.project.srvcliente.domain.exception.ClienteException;
import com.project.srvcliente.utils.Constants.Constantes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String sobreNome;
    @Column
    private int cpf;
    @Column
    private int telefone;
    @Column
    private String logradouro;
    @Column
    private String numero;
    @Column
    private String bairro;
    @Column
    private String complemento;
    @Column
    private int cep;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String pais;

    public void validarNome() throws ClienteException {
        if (String.valueOf(nome).isBlank()) {
            throw new ClienteException(Constantes.NOME_VAZIO);
        }
    }
    public void validarSobrenome() throws ClienteException {
        if (String.valueOf(sobreNome).isBlank()) {
            throw new ClienteException(Constantes.SOBRENOME_VAZIO);
        }
    }
    public void validarTelefone() throws ClienteException {
        if (String.valueOf(telefone).isBlank()) {
            throw new ClienteException(Constantes.TELEFONE_VAZIO);
        }
    }
    public void validarEndereco() throws ClienteException {
        if (String.valueOf(logradouro).isBlank()) {
            throw new ClienteException(Constantes.LOGRADOURO_VAZIO);
        }
        if (String.valueOf(numero).isBlank()) {
            throw new ClienteException(Constantes.NUMERO_VAZIO);
        }
        if (String.valueOf(bairro).isBlank()) {
            throw new ClienteException(Constantes.BAIRRO_VAZIO);
        }
        if (String.valueOf(cep).isBlank()) {
            throw new ClienteException(Constantes.CEP_VAZIO);
        }
        if (String.valueOf(cidade).isBlank()) {
            throw new ClienteException(Constantes.CIDADE_VAZIO);
        }
        if (String.valueOf(estado).isBlank()) {
            throw new ClienteException(Constantes.ESTADO_VAZIO);
        }
        if (String.valueOf(pais).isBlank()) {
            throw new ClienteException(Constantes.PAIS_VAZIO);
        }
    }
    public void validarCpf() throws ClienteException {
        if (String.valueOf(cpf).isBlank()) {
            throw new ClienteException(Constantes.CPF_VAZIO);
        }
    }
}
