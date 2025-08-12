package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TBL_FUNCIONARIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Integer id;

    @Column(name = "NOME_FUNCIONARIO")
    private String nome;

    @Column(name = "SENHA_FUNCIONARIO")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "ID_PESQUEIRO")
    private Pesqueiro pesqueiro;

    @ManyToMany
    @JoinTable(name = "TBL_GERENCIA",
            joinColumns = @JoinColumn(name = "ID_FUNCIONARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_EQUIPAMENTOS"))
    private List<Equipamento> equipamentosUsados;
}
