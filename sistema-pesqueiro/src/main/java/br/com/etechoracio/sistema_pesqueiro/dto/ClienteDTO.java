package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String email;
}
