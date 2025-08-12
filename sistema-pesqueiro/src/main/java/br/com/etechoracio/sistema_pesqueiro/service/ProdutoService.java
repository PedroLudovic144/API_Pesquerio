package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ProdutoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.entity.Produto;
import br.com.etechoracio.sistema_pesqueiro.repository.PesqueiroRepository;
import br.com.etechoracio.sistema_pesqueiro.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final PesqueiroRepository pesqueiroRepository;

    public ProdutoService(ProdutoRepository produtoRepository, PesqueiroRepository pesqueiroRepository) {
        this.produtoRepository = produtoRepository;
        this.pesqueiroRepository = pesqueiroRepository;
    }

    public ProdutoDTO toDto(Produto p) {
        if (p == null) return null;
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setQuantidade(p.getQuantidade());
        dto.setValor(p.getValor());
        dto.setFornecedor(p.getFornecedor());
        dto.setPesqueiroId(p.getPesqueiro() != null ? p.getPesqueiro().getId() : null);
        return dto;
    }

    public Produto toEntity(ProdutoDTO dto) {
        if (dto == null) return null;
        Produto p = new Produto();
        p.setId(dto.getId());
        p.setNome(dto.getNome());
        p.setQuantidade(dto.getQuantidade());
        p.setValor(dto.getValor());
        p.setFornecedor(dto.getFornecedor());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro pesq = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            p.setPesqueiro(pesq);
        } else {
            p.setPesqueiro(null);
        }
        return p;
    }

    public ProdutoDTO create(ProdutoDTO dto) {
        Produto entity = toEntity(dto);
        Produto saved = produtoRepository.save(entity);
        return toDto(saved);
    }

    public ProdutoDTO update(Integer id, ProdutoDTO dto) {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) return null;
        Produto entity = opt.get();
        entity.setNome(dto.getNome());
        entity.setQuantidade(dto.getQuantidade());
        entity.setValor(dto.getValor());
        entity.setFornecedor(dto.getFornecedor());
        if (dto.getPesqueiroId() != null) {
            Pesqueiro pesq = pesqueiroRepository.findById(dto.getPesqueiroId())
                    .orElse(Pesqueiro.builder().id(dto.getPesqueiroId()).build());
            entity.setPesqueiro(pesq);
        } else {
            entity.setPesqueiro(null);
        }
        Produto saved = produtoRepository.save(entity);
        return toDto(saved);
    }

    public ProdutoDTO findById(Integer id) {
        return produtoRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }
}
