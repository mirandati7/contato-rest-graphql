package br.com.curso.contato.graphql;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/hello";
        ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);
        return  "Graphql TO ..: " +  result.getBody().toString();
    }

    public int soma(int a,int b) {
        return a +b;
    }
    
}
