package com.project.srvcliente.utils.mapper;

import com.project.srvcliente.domain.dto.ClienteDTO;
import com.project.srvcliente.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

     void dtoToCliente(ClienteDTO dto, @MappingTarget Cliente cliente);
}
