package br.com.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringServiceTest {

    StringService service = new StringService();

//  input A, ABCD => BCD

    @Test
    public void teste(){
        String retorno = service.removerLetra("A", "ABCD");
        Assertions.assertEquals("BCD", retorno);

        retorno = service.removerLetra("A", "AABCD");
        Assertions.assertEquals("ABCD", retorno);

        retorno = service.removerLetra("A", "BABC");
        Assertions.assertEquals("BBC", retorno);

        retorno = service.removerLetra("A", "BCDE");
        Assertions.assertEquals("BCDE", retorno);

        retorno = service.removerLetra("a", "ABCD");
        Assertions.assertEquals("BCD", retorno);

    }

}
