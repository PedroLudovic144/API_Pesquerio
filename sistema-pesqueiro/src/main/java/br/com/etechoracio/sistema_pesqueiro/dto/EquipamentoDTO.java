package br.com.etechoracio.sistema_pesqueiro.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipamentoDTO {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Boolean equipamentoEmUso;
    private Integer pesqueiroId;
}
