package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.ComentarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {
    @Mapping(source = "pesqueiro.id", target = "pesqueiroId")
    @Mapping(source = "cliente.id", target = "clienteId")
    ComentarioDTO toDto(Comentario entity);

    // Aqui só mapeia os campos simples, sem tentar criar Pesqueiro/Cliente
    @Mapping(target = "pesqueiro", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    Comentario toEntity(ComentarioDTO dto);
}
