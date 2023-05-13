package br.com.service;

import br.com.domain.Carrinho;
import br.com.exception.PromocaoException;
import br.com.model.entity.ProdutoEntity;
import br.com.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    public void finalizarCompra(Carrinho request){
        request.getProdutos().forEach((idProduto, qtdCompra) ->{
            ProdutoEntity produto = repository.findById(idProduto).get();
            if (qtdCompra > produto.getQuantidade()){
                throw new RuntimeException("Quantidade em estoque insuficiente");
            } else if (produto.getPromocao() && qtdCompra > 3) {
                throw new PromocaoException("Produto em promoção só pode 3 unidades");
            } else {
                produto.setQuantidade(produto.getQuantidade() - qtdCompra);
                repository.save(produto);
            }
        });
    }

}
