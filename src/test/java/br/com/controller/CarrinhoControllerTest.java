package br.com.controller;

import br.com.domain.Produto;
import br.com.model.entity.ProdutoEntity;
import br.com.repository.CarrinhoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;

@SpringBootTest
@AutoConfigureMockMvc
public class CarrinhoControllerTest {

    @Autowired
    private CarrinhoController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarrinhoRepository repository;


    @Test
    public void carregouContexto(){
        Assertions.assertTrue(controller != null);
    }

    @Test
    public void testeOk() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/carrinho"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void afetuarCompraComSeucesso() throws Exception {

        ProdutoEntity entidade = new ProdutoEntity();
        entidade.setNome("Copo");
        entidade.setDescricao("250ml");
        entidade.setValor(5d);
        entidade.setQuantidade(10);

        repository.save(entidade);

        CarrinhoRequest carrinho = new CarrinhoRequest();
        carrinho.getProdutos().put(1, 2);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(carrinho);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/carrinho")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        ProdutoEntity produto = repository.findById(1).get();
        Assertions.assertEquals(8, produto.getQuantidade());
    }

}
