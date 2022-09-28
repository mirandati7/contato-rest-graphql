package br.com.curso.contato.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.service.PessoaService;

@Component
public class PessoaGraphQL implements GraphQLQueryResolver {

    @Autowired
    private PessoaService pessoaService;

    public List<PessoaDTO> pessoas(){
        return pessoaService.listar();
    }

    public List<PessoaDTO> pessoasRest(){
        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<List<PessoaDTO>> response = restTemplate.getForEntity( "http://localhost:8080/listar/", PessoaDTO[].class);
        String theUrl = "http://localhost:8080/listar/";
        ResponseEntity<List<PessoaDTO>> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<PessoaDTO>>() {
        });
        List<PessoaDTO> todoList = response.getBody();
        return todoList;
    }
    
}
