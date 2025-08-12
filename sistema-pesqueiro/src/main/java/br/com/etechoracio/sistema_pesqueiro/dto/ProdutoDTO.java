package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private Integer quantidade;
    private Double valor;
    private String fornecedor;
    private Integer pesqueiroId;
}
