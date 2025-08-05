package br.com.etechoracio.sistema_pesqueiro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "TBL_FUNCIONARIOS")
public class Funcionario {

    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @Column(name = "NOME_FUNCIONARIO")
    private String  nomeFuncionario;

    @Column(name = " SENHA_FUNCIONARIO")
    private String  SENHA_FUNCIONARIO;


}
