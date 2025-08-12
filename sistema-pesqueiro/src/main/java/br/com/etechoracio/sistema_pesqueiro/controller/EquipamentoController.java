package br.com.etechoracio.sistema_pesqueiro.controller;

import br.com.etechoracio.sistema_pesqueiro.dto.EquipamentoDTO;
import br.com.etechoracio.sistema_pesqueiro.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping
    public ResponseEntity<EquipamentoDTO> create(@RequestBody EquipamentoDTO dto) {
        return ResponseEntity.ok(equipamentoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> update(@PathVariable Integer id, @RequestBody EquipamentoDTO dto) {
        EquipamentoDTO updated = equipamentoService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> getById(@PathVariable Integer id) {
        EquipamentoDTO dto = equipamentoService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> getAll() {
        return ResponseEntity.ok(equipamentoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        equipamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
