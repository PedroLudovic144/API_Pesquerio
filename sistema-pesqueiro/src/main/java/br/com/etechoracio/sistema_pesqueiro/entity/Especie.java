package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_ESPECIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESPECIE")
    private Integer id;

    @Column(name = "NOME_ESPECIE")
    private String nome;

    @Column(name = "VALOR_ESPECIE")
    private Double valor;

    @Column(name = "FORNECEDOR_ESPECIE")
    private String fornecedor;
}
