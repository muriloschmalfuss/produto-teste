package br.com.controller;

import br.com.domain.Carrinho;
import br.com.exception.PromocaoException;
import br.com.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/carrinho", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CarrinhoController {

    @Autowired
    CarrinhoService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity finalizarCompra(@RequestBody CarrinhoRequest carrinhoRequest){
        try {
            service.finalizarCompra(carrinhoRequest.toCarrinho());
            return ResponseEntity.ok().build();
        } catch (PromocaoException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public HttpStatusCode ok(){
        return HttpStatus.OK;
    }


}
