package br.com.repository;

import br.com.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<ProdutoEntity,Integer > {

    Integer findQuantidadeById(Integer id);

//    void realizarCompra(Carrinho request);
//
//    Integer buscarQtdProdutoPorId(Integer id);
}