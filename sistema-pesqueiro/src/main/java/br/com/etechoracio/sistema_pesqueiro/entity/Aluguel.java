package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_ALUGUEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUGUEL")
    private Integer id;

    @Column(name = "VALOR_ALUGUEL")
    private Double valor;

    @Column(name = "DATA_HORA_RETIRADA")
    private LocalDateTime dataHoraRetirada;

    @Column(name = "DATA_HORA_DEVOLUCAO")
    private LocalDateTime dataHoraDevolucao;

    @Column(name = "OBSERVACAO", length = 1000)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTOS")
    private Equipamento equipamento;
}
