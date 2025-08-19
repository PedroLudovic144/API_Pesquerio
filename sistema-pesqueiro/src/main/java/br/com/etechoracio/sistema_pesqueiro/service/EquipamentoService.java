package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.EquipamentoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Equipamento;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.mapper.EquipamentoMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, EquipamentoMapper equipamentoMapper) {
        this.equipamentoRepository = equipamentoRepository;
        this.equipamentoMapper = equipamentoMapper;
    }

    public EquipamentoDTO create(EquipamentoDTO dto) {
        Equipamento entity = equipamentoMapper.toEntity(dto);
        Equipamento saved = equipamentoRepository.save(entity);
        return equipamentoMapper.toDto(saved);
    }

    public EquipamentoDTO update(Integer id, EquipamentoDTO dto) {
        Optional<Equipamento> opt = equipamentoRepository.findById(id);
        if (opt.isEmpty()) return null;
        Equipamento entity = opt.get();
        entity.setNome(dto.nome());
        entity.setResponsavelPesqueiro(dto.pesqueiroId() != null ? new Pesqueiro(dto.pesqueiroId()) : null);
        Equipamento saved = equipamentoRepository.save(entity);
        return equipamentoMapper.toDto(saved);
    }

    public EquipamentoDTO findById(Integer id) {
        return equipamentoRepository.findById(id).map(equipamentoMapper::toDto).orElse(null);
    }

    public List<EquipamentoDTO> findAll() {
        return equipamentoRepository.findAll().stream().map(equipamentoMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        equipamentoRepository.deleteById(id);
    }
}
