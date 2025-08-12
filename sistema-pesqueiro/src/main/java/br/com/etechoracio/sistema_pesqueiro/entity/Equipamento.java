package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_EQUIPAMENTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPAMENTOS")
    private Integer id;

    @Column(name = "NOME_EQUIPAMENTO")
    private String nome;

    @Column(name = "QUANTIDADE_EQUIPAMENTO")
    private Integer quantidade;

    @Column(name = "EQUIPAMENTO_EM_USO")
    private Boolean equipamentoEmUso;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ULTIMO_USO")
    private String ultimoUso;

    @ManyToOne
    @JoinColumn(name = "ID_PESQUEIRO")
    private Pesqueiro responsavelPesqueiro;
}
