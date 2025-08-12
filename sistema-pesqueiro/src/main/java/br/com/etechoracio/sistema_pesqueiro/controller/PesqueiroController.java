package br.com.etechoracio.sistema_pesqueiro.controller;

import br.com.etechoracio.sistema_pesqueiro.dto.PesqueiroDTO;
import br.com.etechoracio.sistema_pesqueiro.service.PesqueiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesqueiros")
public class PesqueiroController {

    private final PesqueiroService pesqueiroService;

    public PesqueiroController(PesqueiroService pesqueiroService) {
        this.pesqueiroService = pesqueiroService;
    }

    @PostMapping
    public ResponseEntity<PesqueiroDTO> create(@RequestBody PesqueiroDTO dto) {
        return ResponseEntity.ok(pesqueiroService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PesqueiroDTO> update(@PathVariable Integer id, @RequestBody PesqueiroDTO dto) {
        PesqueiroDTO updated = pesqueiroService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PesqueiroDTO> getById(@PathVariable Integer id) {
        PesqueiroDTO dto = pesqueiroService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PesqueiroDTO>> getAll() {
        return ResponseEntity.ok(pesqueiroService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pesqueiroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
