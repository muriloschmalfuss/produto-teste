package br.com.service;

public class StringService {

    public String removerLetra(String letra, String palavra) {

        return palavra.toUpperCase().replaceFirst(letra.toUpperCase(), "");
    }

}
