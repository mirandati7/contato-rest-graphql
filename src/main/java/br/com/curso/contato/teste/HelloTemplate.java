package br.com.curso.contato.teste;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloTemplate {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
     
        final String baseUrl = "http://localhost:8080/hello";
        ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);
        System.out.println("Resultado ..: " +  result.getBody().toString());
    }
    
}
