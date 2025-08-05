package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "TBL_EQUIPAMENTOS")
public class Equipamento {
    @Id
    @Column(name = "ID_EQUIPAMENTOS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamentos;

    @Column(name = "NOME_EQUIPAMENTO")
    private String nomeEquipamneto;

    @Column(name = "EQUIPAMENTO_EM_USO")
    private boolean equipamentoUso;

    @Column(name = " QUANTIDADE_EQUIPAMENTO")
    private int quantidadeEquipamento;
}
