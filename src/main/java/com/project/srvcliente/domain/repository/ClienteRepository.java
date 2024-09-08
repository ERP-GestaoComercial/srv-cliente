package com.project.srvcliente.domain.repository;

import com.project.srvcliente.domain.dto.ComprasDTO;
import com.project.srvcliente.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findClienteByCpf(String cpf);

    //@Query("FZER A QUERY")
    List<ComprasDTO> findComprasByCpf(@Param("cpf") String id);
}
