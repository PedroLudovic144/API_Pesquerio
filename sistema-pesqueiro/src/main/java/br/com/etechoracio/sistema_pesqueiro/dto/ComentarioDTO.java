package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioDTO {
    private Integer id;
    private String texto;
    private Integer avaliacao;
    private Integer clienteId;
    private Integer pesqueiroId;
}
