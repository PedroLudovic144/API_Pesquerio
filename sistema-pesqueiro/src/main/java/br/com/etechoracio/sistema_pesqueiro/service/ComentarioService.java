package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ComentarioDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Comentario;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import br.com.etechoracio.sistema_pesqueiro.repository.ComentarioRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PesqueiroRepository pesqueiroRepository;
    private final ClienteRepository clienteRepository;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             PesqueiroRepository pesqueiroRepository,
                             ClienteRepository clienteRepository) {
        this.comentarioRepository = comentarioRepository;
        this.pesqueiroRepository = pesqueiroRepository;
        this.clienteRepository = clienteRepository;
    }

    public ComentarioDTO toDto(Comentario c) {
        if (c == null) return null;
        ComentarioDTO dto = new ComentarioDTO();
        dto.setId(c.getId());
        dto.setTexto(c.getTexto());
        dto.setPesqueiroId(c.getPesqueiro() != null ? c.getPesqueiro().getId() : null);
        dto.setClienteId(c.getCliente() != null ? c.getCliente().getId() : null);
        return dto;
    }

    public Comentario toEntity(ComentarioDTO dto) {
        if (dto == null) return null;
        Comentario c = new Comentario();
        c.setId(dto.getId());
        c.setTexto(dto.getTexto());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro p = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            c.setPesqueiro(p);
        } else {
            c.setPesqueiro(null);
        }
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElse(Cliente.builder().id(dto.getClienteId()).build());
            c.setCliente(cliente);
        } else {
            c.setCliente(null);
        }
        return c;
    }

    public ComentarioDTO create(ComentarioDTO dto) {
        Comentario entity = toEntity(dto);
        Comentario saved = comentarioRepository.save(entity);
        return toDto(saved);
    }

    public ComentarioDTO update(Integer id, ComentarioDTO dto) {
        Optional<Comentario> opt = comentarioRepository.findById(id);
        if (opt.isEmpty()) return null;
        Comentario entity = opt.get();
        entity.setTexto(dto.getTexto());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro p = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            entity.setPesqueiro(p);
        } else {
            entity.setPesqueiro(null);
        }
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElse(Cliente.builder().id(dto.getClienteId()).build());
            entity.setCliente(cliente);
        } else {
            entity.setCliente(null);
        }
        Comentario saved = comentarioRepository.save(entity);
        return toDto(saved);
    }

    public ComentarioDTO findById(Integer id) {
        return comentarioRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ComentarioDTO> findAll() {
        return comentarioRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        comentarioRepository.deleteById(id);
    }
}
