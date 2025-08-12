package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.ProdutoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "pesqueiroId", source = "pesqueiro.id")
    ProdutoDTO toDto(Produto entity);

    @Mapping(target = "pesqueiro", expression = "java(dto.pesqueiroId() == null ? null : new Pesqueiro(dto.pesqueiroId()))")
    Produto toEntity(ProdutoDTO dto);
}
