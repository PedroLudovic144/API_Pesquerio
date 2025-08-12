package br.com.etechoracio.sistema_pesqueiro.dto;

import lombok.*;

@Builder
public record ProdutoDTO(Integer id,String nome,Integer quantidade,Double valor,String fornecedor,Integer pesqueiroId) {}
