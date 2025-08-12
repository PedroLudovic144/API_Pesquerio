package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.PesqueiroDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PesqueiroMapper {

    PesqueiroDTO toDto(Pesqueiro entity);

    Pesqueiro toEntity(PesqueiroDTO dto);
}
