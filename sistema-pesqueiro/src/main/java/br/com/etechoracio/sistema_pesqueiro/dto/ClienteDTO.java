package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.Builder;

@Builder
public record ClienteDTO(Integer id,String nome,String email  ) {}
