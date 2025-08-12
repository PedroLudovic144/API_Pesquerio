package br.com.etechoracio.sistema_pesqueiro.repository;

import br.com.etechoracio.sistema_pesqueiro.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
