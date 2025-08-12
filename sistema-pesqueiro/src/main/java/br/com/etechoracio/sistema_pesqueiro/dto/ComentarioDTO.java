package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Builder
public record ComentarioDTO(Integer id,String texto,Integer avaliacao, Integer clienteId, Integer pesqueiroId  ) { }
