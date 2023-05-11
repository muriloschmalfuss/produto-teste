package br.com.repository.impl;

import br.com.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository {

    List<String> produtos = new ArrayList<>();

    @Override
    public void salvar(String produto) {
        produtos.add(produto);
    }

    @Override
    public List<String> consultarTodos() {
        return produtos;
    }
}
