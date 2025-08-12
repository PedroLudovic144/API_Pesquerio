package br.com.etechoracio.sistema_pesqueiro.dto;
import lombok.*;


@Builder
public record EquipamentoDTO(Integer id,String nome,Integer quantidade,Boolean equipamentoEmUso,Integer pesqueiroId) { }
