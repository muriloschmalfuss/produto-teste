package br.com.repository;

import java.util.List;

public interface ProdutoRepository {

    void salvar(String produto);

    List<String> consultarTodos();

}
