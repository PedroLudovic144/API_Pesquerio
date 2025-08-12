package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Integer pesqueiroId;
}
