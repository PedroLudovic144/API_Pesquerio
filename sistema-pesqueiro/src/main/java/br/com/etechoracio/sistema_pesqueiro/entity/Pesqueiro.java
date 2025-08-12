package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "TBL_PESQUEIRO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pesqueiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESQUEIRO")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FOTOS", length = 2000)
    private String fotos;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "TELEFONE")
    private String telefone;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Peixe> peixes;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lago> lagos;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipamento> equipamentos;

    @OneToMany(mappedBy = "pesqueiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
}
