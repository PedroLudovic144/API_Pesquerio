package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.ClienteDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDto(Cliente entity);
    Cliente toEntity(ClienteDTO dto);
}
