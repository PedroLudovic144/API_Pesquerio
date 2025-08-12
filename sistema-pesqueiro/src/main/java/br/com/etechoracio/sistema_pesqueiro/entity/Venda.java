package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_COMPRA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPRA")
    private Integer id;

    @Column(name = "DT_COMPRA")
    private LocalDate data;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
}
