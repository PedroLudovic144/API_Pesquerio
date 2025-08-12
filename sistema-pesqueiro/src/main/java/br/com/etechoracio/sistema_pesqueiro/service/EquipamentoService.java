package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.EquipamentoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Equipamento;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.repository.EquipamentoRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final PesqueiroRepository pesqueiroRepository;
    private final FuncionarioRepository funcionarioRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository,
                              PesqueiroRepository pesqueiroRepository,
                              FuncionarioRepository funcionarioRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.pesqueiroRepository = pesqueiroRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public EquipamentoDTO toDto(Equipamento e) {
        if (e == null) return null;
        EquipamentoDTO dto = new EquipamentoDTO();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setPesqueiroId(e.getPesqueiro() != null ? e.getPesqueiro().getId() : null);
        dto.setFuncionarioId(e.getFuncionario() != null ? e.getFuncionario().getId() : null);
        return dto;
    }

    public Equipamento toEntity(EquipamentoDTO dto) {
        if (dto == null) return null;
        Equipamento e = new Equipamento();
        e.setId(dto.getId());
        e.setNome(dto.getNome());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro p = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            e.setPesqueiro(p);
        } else {
            e.setPesqueiro(null);
        }
        if (dto.getFuncionarioId() != null) {
            Funcionario f = funcionarioRepository.findById(dto.getFuncionarioId())
                    .orElse(Funcionario.builder().id(dto.getFuncionarioId()).build());
            e.setFuncionario(f);
        } else {
            e.setFuncionario(null);
        }
        return e;
    }

    public EquipamentoDTO create(EquipamentoDTO dto) {
        Equipamento entity = toEntity(dto);
        Equipamento saved = equipamentoRepository.save(entity);
        return toDto(saved);
    }

    public EquipamentoDTO update(Integer id, EquipamentoDTO dto) {
        Optional<Equipamento> opt = equipamentoRepository.findById(id);
        if (opt.isEmpty()) return null;
        Equipamento entity = opt.get();
        entity.setNome(dto.getNome());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro p = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            entity.setPesqueiro(p);
        } else {
            entity.setPesqueiro(null);
        }
        if (dto.getFuncionarioId() != null) {
            Funcionario f = funcionarioRepository.findById(dto.getFuncionarioId())
                    .orElse(Funcionario.builder().id(dto.getFuncionarioId()).build());
            entity.setFuncionario(f);
        } else {
            entity.setFuncionario(null);
        }
        Equipamento saved = equipamentoRepository.save(entity);
        return toDto(saved);
    }

    public EquipamentoDTO findById(Integer id) {
        return equipamentoRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<EquipamentoDTO> findAll() {
        return equipamentoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        equipamentoRepository.deleteById(id);
    }
}
