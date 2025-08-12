package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Builder
public record FuncionarioDTO(Integer id, String nome ,Integer pesqueiroId ) { }
