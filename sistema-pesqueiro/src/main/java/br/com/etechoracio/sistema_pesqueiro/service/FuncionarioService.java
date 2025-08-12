package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.FuncionarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Funcionario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.mapper.FuncionarioMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public FuncionarioDTO create(FuncionarioDTO dto) {
        Funcionario entity = funcionarioMapper.toEntity(dto);
        Funcionario saved = funcionarioRepository.save(entity);
        return funcionarioMapper.toDto(saved);
    }

    public FuncionarioDTO update(Integer id, FuncionarioDTO dto) {
        Optional<Funcionario> opt = funcionarioRepository.findById(id);
        if (opt.isEmpty()) return null;
        Funcionario entity = opt.get();
        entity.setNome(dto.nome());
        entity.setPesqueiro(dto.pesqueiroId() != null ? new Pesqueiro(dto.pesqueiroId()) : null);
        Funcionario saved = funcionarioRepository.save(entity);
        return funcionarioMapper.toDto(saved);
    }

    public FuncionarioDTO findById(Integer id) {
        return funcionarioRepository.findById(id).map(funcionarioMapper::toDto).orElse(null);
    }

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream().map(funcionarioMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
