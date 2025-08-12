package br.com.etechoracio.sistema_pesqueiro.repository;


import br.com.etechoracio.sistema_pesqueiro.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
