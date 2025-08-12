package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_PEIXE_CAPTURADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Peixe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEIXE_CAPTURADO")
    private Integer id;

    @Column(name = "NOME_PEIXE")
    private String nome;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "DATA_PEIXE_CAPTURADO")
    private java.time.LocalDate dataCaptura;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIE")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "ID_PESQUEIRO")
    private Pesqueiro pesqueiro;
}
