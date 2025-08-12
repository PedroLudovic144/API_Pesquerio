package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.PesqueiroDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.mapper.PesqueiroMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PesqueiroService {

    private final PesqueiroRepository pesqueiroRepository;
    private final PesqueiroMapper pesqueiroMapper;

    public PesqueiroService(PesqueiroRepository pesqueiroRepository, PesqueiroMapper pesqueiroMapper) {
        this.pesqueiroRepository = pesqueiroRepository;
        this.pesqueiroMapper = pesqueiroMapper;
    }

    public PesqueiroDTO create(PesqueiroDTO dto) {
        Pesqueiro entity = pesqueiroMapper.toEntity(dto);
        Pesqueiro saved = pesqueiroRepository.save(entity);
        return pesqueiroMapper.toDto(saved);
    }

    public PesqueiroDTO update(Integer id, PesqueiroDTO dto) {
        Optional<Pesqueiro> opt = pesqueiroRepository.findById(id);
        if (opt.isEmpty()) return null;
        Pesqueiro entity = opt.get();
        entity.setNome(dto.nome());
        Pesqueiro saved = pesqueiroRepository.save(entity);
        return pesqueiroMapper.toDto(saved);
    }

    public PesqueiroDTO findById(Integer id) {
        return pesqueiroRepository.findById(id).map(pesqueiroMapper::toDto).orElse(null);
    }

    public List<PesqueiroDTO> findAll() {
        return pesqueiroRepository.findAll().stream().map(pesqueiroMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        pesqueiroRepository.deleteById(id);
    }
}
