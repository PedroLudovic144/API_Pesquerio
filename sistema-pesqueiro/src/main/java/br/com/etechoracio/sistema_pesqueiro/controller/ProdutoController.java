package br.com.etechoracio.sistema_pesqueiro.controller;

import br.com.etechoracio.sistema_pesqueiro.dto.ProdutoDTO;
import br.com.etechoracio.sistema_pesqueiro.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @RequestBody ProdutoDTO dto) {
        ProdutoDTO updated = produtoService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Integer id) {
        ProdutoDTO dto = produtoService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
