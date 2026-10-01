package br.univille.chamados.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String teste() {
        return "Aplicação Funcionando";
    }

    @GetMapping("/identificacao") // Anotação de mapeamento de rotas para o HTTP GET para o link /identificacao
    public String identificador() { // Função que é chamada ao entrar na rota
        return "Projeto Spring em Execução";
    }


}
