package br.com.etechoracio.sistema_pesqueiro.mapper;

import br.com.etechoracio.sistema_pesqueiro.dto.EquipamentoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import br.com.etechoracio.sistema_pesqueiro.entity.Equipamento;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    @Mapping(target = "pesqueiroId", source = "pesqueiro.id")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    EquipamentoDTO toDto(Equipamento entity);

    @Mapping(target = "pesqueiro", expression = "java(dto.pesqueiroId() == null ? null : new Pesqueiro(dto.pesqueiroId()))")
    @Mapping(target = "funcionario", expression = "java(dto.funcionarioId() == null ? null : new Funcionario(dto.funcionarioId()))")
    Equipamento toEntity(EquipamentoDTO dto);
}
