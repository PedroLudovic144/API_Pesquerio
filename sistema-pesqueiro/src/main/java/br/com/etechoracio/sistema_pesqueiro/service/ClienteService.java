package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ClienteDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Cliente;
import br.com.etechoracio.sistema_pesqueiro.mapper.ClienteMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDTO create(ClienteDTO dto) {
        Cliente entity = clienteMapper.toEntity(dto);
        Cliente saved = clienteRepository.save(entity);
        return clienteMapper.toDto(saved);
    }

    public ClienteDTO update(Integer id, ClienteDTO dto) {
        Optional<Cliente> opt = clienteRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }
        Cliente entity = opt.get();
        // Atualiza apenas os campos necessários
        entity.setNome(dto.nome());
        entity.setEmail(dto.email());
        Cliente saved = clienteRepository.save(entity);
        return clienteMapper.toDto(saved);
    }

    public ClienteDTO findById(Integer id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDto)
                .orElse(null);
    }

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}
