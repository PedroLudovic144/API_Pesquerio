package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ClienteDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import br.com.etechoracio.sistema_pesqueiro.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO toDto(Cliente c) {
        if (c == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setId(c.getId());
        dto.setNome(c.getNome());
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        Cliente c = new Cliente();
        c.setId(dto.getId());
        c.setNome(dto.getNome());
        return c;
    }

    public ClienteDTO create(ClienteDTO dto) {
        Cliente e = toEntity(dto);
        Cliente saved = clienteRepository.save(e);
        return toDto(saved);
    }

    public ClienteDTO update(Integer id, ClienteDTO dto) {
        Optional<Cliente> opt = clienteRepository.findById(id);
        if (opt.isEmpty()) return null;
        Cliente entity = opt.get();
        entity.setNome(dto.getNome());
        Cliente saved = clienteRepository.save(entity);
        return toDto(saved);
    }

    public ClienteDTO findById(Integer id) {
        return clienteRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}
