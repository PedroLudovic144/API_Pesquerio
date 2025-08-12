package br.com.etechoracio.sistema_pesqueiro.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_PRODUTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Integer id;

    @Column(name = "NOME_PRODUTO")
    private String nome;

    @Column(name = "QTD_PRODUTO")
    private Integer quantidade;

    @Column(name = "VALOR_PRODUTO")
    private Double valor;

    @Column(name = "FORNECEDOR")
    private String fornecedor;

    @ManyToOne
    @JoinColumn(name = "ID_PESQUEIRO")
    private Pesqueiro pesqueiro;
}