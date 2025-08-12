package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TBL_CLIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer id;

    @Column(name = "NOME_CLIENTE")
    private String nome;

    @Column(name = "EMAIL_CLIENTE")
    private String email;

    @Column(name = "SENHA_CLIENTE")
    private String senha;

    @ManyToMany
    @JoinTable(name = "TBL_FAVORITOS",
            joinColumns = @JoinColumn(name = "ID_CLIENTE"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESQUEIRO"))
    private List<Pesqueiro> favoritos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
}
