package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.FuncionarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.repository.FuncionarioRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PesqueiroRepository pesqueiroRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, PesqueiroRepository pesqueiroRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.pesqueiroRepository = pesqueiroRepository;
    }

    public FuncionarioDTO toDto(Funcionario f) {
        if (f == null) return null;
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        dto.setPesqueiroId(f.getPesqueiro() != null ? f.getPesqueiro().getId() : null);
        return dto;
    }

    public Funcionario toEntity(FuncionarioDTO dto) {
        if (dto == null) return null;
        Funcionario f = new Funcionario();
        f.setId(dto.getId());
        f.setNome(dto.getNome());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro pesq = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            f.setPesqueiro(pesq);
        } else {
            f.setPesqueiro(null);
        }
        return f;
    }

    public FuncionarioDTO create(FuncionarioDTO dto) {
        Funcionario entity = toEntity(dto);
        Funcionario saved = funcionarioRepository.save(entity);
        return toDto(saved);
    }

    public FuncionarioDTO update(Integer id, FuncionarioDTO dto) {
        Optional<Funcionario> opt = funcionarioRepository.findById(id);
        if (opt.isEmpty()) return null;
        Funcionario entity = opt.get();
        entity.setNome(dto.getNome());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro pesq = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            entity.setPesqueiro(pesq);
        } else {
            entity.setPesqueiro(null);
        }
        Funcionario saved = funcionarioRepository.save(entity);
        return toDto(saved);
    }

    public FuncionarioDTO findById(Integer id) {
        return funcionarioRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
