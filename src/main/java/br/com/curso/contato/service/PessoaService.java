package br.com.curso.contato.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.contato.dto.PessoaDTO;
import br.com.curso.contato.model.Pessoa;
import br.com.curso.contato.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<PessoaDTO> listar() {
        List<Pessoa>  pessoas =  pessoaRepository.findAll();
        List<PessoaDTO> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            PessoaDTO dto = new PessoaDTO();
            dtos.add(dto.toModel(pessoa));
        }
        return dtos;
    }


    public PessoaDTO consultar(Integer id) {        
        return null;
    }

    /**
     * Classe service usada para regras de negocio
     * @param pessoaDTO
     * @return
     */
    public PessoaDTO salvar(PessoaDTO dto) {
        System.out.println("Acessando a classe Service");
        
        if (dto.getIdade() < 18) {
            System.out.println("Não e possível cadastrar menor de idade.");
            
            Pessoa model = new Pessoa();
            model.setId(dto.getId());
            model.setEmail(dto.getEmail());
            model.setNome(dto.getNome());
            model.setTelefone(dto.getTelefone());
            model.setIdade(dto.getIdade());


            Pessoa pessoaRetornada = pessoaRepository.save(model);
            System.out.println("ID .. :" + pessoaRetornada.getId());
        } else {
            dto.setIdade(dto.getIdade() + 5);
            System.out.println("Cadastro feito com sucesso.");
        }
        
        return dto;
    }


    
}
