package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.FuncionarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    @Mapping(target = "pesqueiroId", source = "pesqueiro.id")
    FuncionarioDTO toDto(Funcionario entity);

    @Mapping(target = "pesqueiro", expression = "java(dto.pesqueiroId() == null ? null : new Pesqueiro(dto.pesqueiroId()))")
    Funcionario toEntity(FuncionarioDTO dto);
}
