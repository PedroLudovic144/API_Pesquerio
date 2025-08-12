package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PesqueiroDTO {
    private Integer id;
    private String nome;
    private String email;
    private String fotos;
    private Double latitude;
    private Double longitude;
    private String telefone;
}
