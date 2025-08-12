package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_LAGOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LAGO")
    private Integer id;

    @Column(name = "NOME_LAGO")
    private String nome;

    @Column(name = "NUMERO")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "ID_PESQUEIRO")
    private Pesqueiro pesqueiro;
}
