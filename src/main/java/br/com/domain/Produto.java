package br.com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Produto {

    private String nome;
    private String descricao;
    private Long id;
    private Double valor;

}
