package br.com.etechoracio.sistema_pesqueiro.controller;

import br.com.etechoracio.sistema_pesqueiro.dto.ComentarioDTO;
import br.com.etechoracio.sistema_pesqueiro.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> create(@RequestBody ComentarioDTO dto) {
        return ResponseEntity.ok(comentarioService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> update(@PathVariable Integer id, @RequestBody ComentarioDTO dto) {
        ComentarioDTO updated = comentarioService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> getById(@PathVariable Integer id) {
        ComentarioDTO dto = comentarioService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> getAll() {
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        comentarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
