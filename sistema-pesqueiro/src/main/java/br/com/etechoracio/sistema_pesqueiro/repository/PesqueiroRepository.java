package br.com.etechoracio.sistema_pesqueiro.repository;

import br.com.etechoracio.sistema_pesqueiro.entity.Pesqueiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PesqueiroRepository extends JpaRepository<Pesqueiro, Integer> {
}
