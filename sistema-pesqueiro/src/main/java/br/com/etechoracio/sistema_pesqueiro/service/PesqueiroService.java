package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.PesqueiroDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class PesqueiroService {

    private final PesqueiroRepository pesqueiroRepository;

    public PesqueiroService(PesqueiroRepository pesqueiroRepository) {
        this.pesqueiroRepository = pesqueiroRepository;
    }

    public PesqueiroDTO toDto(Pesqueiro p) {
        if (p == null) return null;
        PesqueiroDTO dto = new PesqueiroDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        return dto;
    }

    public Pesqueiro toEntity(PesqueiroDTO dto) {
        if (dto == null) return null;
        Pesqueiro p = new Pesqueiro();
        p.setId(dto.getId());
        p.setNome(dto.getNome());
        return p;
    }

    public PesqueiroDTO create(PesqueiroDTO dto) {
        Pesqueiro entity = toEntity(dto);
        Pesqueiro saved = pesqueiroRepository.save(entity);
        return toDto(saved);
    }

    public PesqueiroDTO update(Integer id, PesqueiroDTO dto) {
        Optional<Pesqueiro> opt = pesqueiroRepository.findById(id);
        if (opt.isEmpty()) return null;
        Pesqueiro entity = opt.get();
        entity.setNome(dto.getNome());
        Pesqueiro saved = pesqueiroRepository.save(entity);
        return toDto(saved);
    }

    public PesqueiroDTO findById(Integer id) {
        return pesqueiroRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<PesqueiroDTO> findAll() {
        return pesqueiroRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        pesqueiroRepository.deleteById(id);
    }
}
