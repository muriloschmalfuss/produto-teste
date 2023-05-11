package br.com.controller;


import br.com.domain.Carrinho;
import br.com.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoRequest {

    private Map<Integer, Integer> produtos = new HashMap<>();

    public Carrinho toCarrinho(){
        return new Carrinho(produtos);
    }

    public Map<Integer, Integer> getProdutos() {
        return produtos;
    }

}