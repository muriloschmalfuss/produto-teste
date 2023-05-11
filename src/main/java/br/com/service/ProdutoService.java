package br.com.service;

import br.com.repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {

    ProdutoRepository repository;

    ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public void salvar(String s) {
        repository.salvar(s);
    }

    public List<String> consultarProdutos(){
        return repository.consultarTodos();
    }
}
