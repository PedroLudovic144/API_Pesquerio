package br.com.etechoracio.sistema_pesqueiro.service;

import br.com.etechoracio.sistema_pesqueiro.dto.ProdutoDTO;
import br.com.etechoracio.sistema_pesqueiro.entity.Produto;
import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import br.com.etechoracio.sistema_pesqueiro.mapper.ProdutoMapper;
import br.com.etechoracio.sistema_pesqueiro.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoDTO create(ProdutoDTO dto) {
        Produto entity = produtoMapper.toEntity(dto);
        Produto saved = produtoRepository.save(entity);
        return produtoMapper.toDto(saved);
    }

    public ProdutoDTO update(Integer id, ProdutoDTO dto) {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) return null;
        Produto entity = opt.get();
        entity.setNome(dto.nome());
        entity.setQuantidade(dto.quantidade());
        entity.setValor(dto.valor());
        entity.setFornecedor(dto.fornecedor());
        entity.setPesqueiro(dto.pesqueiroId() != null ? new Pesqueiro(dto.pesqueiroId()) : null);
        Produto saved = produtoRepository.save(entity);
        return produtoMapper.toDto(saved);
    }

    public ProdutoDTO findById(Integer id) {
        return produtoRepository.findById(id).map(produtoMapper::toDto).orElse(null);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(produtoMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }
}
