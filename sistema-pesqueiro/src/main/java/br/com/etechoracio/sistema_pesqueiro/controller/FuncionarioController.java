package br.com.etechoracio.sistema_pesqueiro.controller;

import br.com.etechoracio.sistema_pesqueiro.dto.FuncionarioDTO;
import br.com.etechoracio.sistema_pesqueiro.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO dto) {
        return ResponseEntity.ok(funcionarioService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Integer id, @RequestBody FuncionarioDTO dto) {
        FuncionarioDTO updated = funcionarioService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getById(@PathVariable Integer id) {
        FuncionarioDTO dto = funcionarioService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
