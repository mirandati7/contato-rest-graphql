package br.com.curso.contato.dto;

import br.com.curso.contato.model.Pessoa;

public class PessoaDTO {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private Integer idade;

    public PessoaDTO(){
    }


    public PessoaDTO(Integer id, String nome, String telefone, String email, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }


    public PessoaDTO toModel(Pessoa pessoa){
        return new PessoaDTO(pessoa.getId(),
                pessoa.getNome(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getIdade());
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    

    
    
}
