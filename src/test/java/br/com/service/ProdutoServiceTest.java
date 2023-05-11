package br.com.service;

import br.com.repository.impl.ProdutoRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProdutoServiceTest {

    @Test
    public void salvarProduto(){
        ProdutoService service = new ProdutoService(new ProdutoRepositoryImpl());
        service.salvar("Notebook");
        List<String> retorno = service.consultarProdutos();
        Assertions.assertTrue(retorno.contains("Notebook"));
    }


}
