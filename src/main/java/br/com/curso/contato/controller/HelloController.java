package br.com.curso.contato.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    @RequestMapping("/")
    public String index() {
        return "Acesso /graphiql para testar a API";
    }

    @GetMapping
    @RequestMapping("/hello")
    public String hello() {
        return "Hello REST";
    }
    
}
