package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ComentarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import br.com.etechoracio.sistema_pesqueiro.entity.Comentario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.mapper.ComentarioMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.ComentarioRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.ClienteRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PesqueiroRepository pesqueiroRepository;
    private final ClienteRepository clienteRepository;
    private final ComentarioMapper comentarioMapper;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             PesqueiroRepository pesqueiroRepository,
                             ClienteRepository clienteRepository,
                             ComentarioMapper comentarioMapper) {
        this.comentarioRepository = comentarioRepository;
        this.pesqueiroRepository = pesqueiroRepository;
        this.clienteRepository = clienteRepository;
        this.comentarioMapper = comentarioMapper;
    }

    public ComentarioDTO create(ComentarioDTO dto) {
        Comentario entity = comentarioMapper.toEntity(dto);

        if (dto.pesqueiroId() != null) {
            entity.setPesqueiro(
                    pesqueiroRepository.findById(dto.pesqueiroId())
                            .orElse(Pesqueiro.builder().id(dto.pesqueiroId()).build())
            );
        }

        if (dto.clienteId() != null) {
            entity.setCliente(
                    clienteRepository.findById(dto.clienteId())
                            .orElse(Cliente.builder().id(dto.clienteId()).build())
            );
        }

        Comentario saved = comentarioRepository.save(entity);
        return comentarioMapper.toDto(saved);
    }

    public ComentarioDTO update(Integer id, ComentarioDTO dto) {
        Optional<Comentario> opt = comentarioRepository.findById(id);
        if (opt.isEmpty()) return null;

        Comentario entity = opt.get();
        entity.setTexto(dto.texto());

        if (dto.pesqueiroId() != null) {
            entity.setPesqueiro(
                    pesqueiroRepository.findById(dto.pesqueiroId())
                            .orElse(Pesqueiro.builder().id(dto.pesqueiroId()).build())
            );
        } else {
            entity.setPesqueiro(null);
        }

        if (dto.clienteId() != null) {
            entity.setCliente(
                    clienteRepository.findById(dto.clienteId())
                            .orElse(Cliente.builder().id(dto.clienteId()).build())
            );
        } else {
            entity.setCliente(null);
        }

        Comentario saved = comentarioRepository.save(entity);
        return comentarioMapper.toDto(saved);
    }

    public ComentarioDTO findById(Integer id) {
        return comentarioRepository.findById(id)
                .map(comentarioMapper::toDto)
                .orElse(null);
    }

    public List<ComentarioDTO> findAll() {
        return comentarioRepository.findAll().stream()
                .map(comentarioMapper::toDto)
                .toList();
    }

    public void deleteById(Integer id) {
        comentarioRepository.deleteById(id);
    }
}
