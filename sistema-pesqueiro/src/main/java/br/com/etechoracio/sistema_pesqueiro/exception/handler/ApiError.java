package br.com.etechoracio.sistema_pesqueiro.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}