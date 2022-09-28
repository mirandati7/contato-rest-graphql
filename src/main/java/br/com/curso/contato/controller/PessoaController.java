package br.com.curso.contato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.service.PessoaService;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value ="/status" , method = RequestMethod.GET )
    public String status() {
        return "Status OK";
    }


    @GetMapping("/consultar")
    public PessoaDTO consultar(@RequestParam("id") Integer id) {
        return pessoaService.consultar(id);
    }

    @GetMapping("/listar")
    public List<PessoaDTO> listar() {
        return pessoaService.listar();
    }


    @PostMapping("/salvar")
    public String salvar(@RequestBody PessoaDTO pessoaDTO) {        
        System.out.println(pessoaDTO.getNome());
        System.out.println(pessoaDTO.getEmail());
        System.out.println(pessoaDTO.getTelefone());
        return "Salvo com sucesso";
    }

    @PostMapping("/salvarComRetorno")
    @ResponseBody
    public PessoaDTO salvarComRetorno(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.salvar(pessoaDTO);
    }


    
}
