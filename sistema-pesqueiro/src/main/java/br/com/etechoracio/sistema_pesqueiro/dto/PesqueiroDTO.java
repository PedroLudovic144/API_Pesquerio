package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Builder
public record PesqueiroDTO(Integer id,String nome,String email,String fotos,Double latitude,Double longitude,String telefone) {}
