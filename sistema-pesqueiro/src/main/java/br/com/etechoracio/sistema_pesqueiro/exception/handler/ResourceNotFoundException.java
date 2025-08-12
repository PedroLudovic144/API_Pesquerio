package br.com.etechoracio.sistema_pesqueiro.exception.handler;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Integer id) {
        super(resource + " com id " + id + " não encontrado");
    }
}
