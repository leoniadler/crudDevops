package br.com.infnet.CrudAlunoDevops.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private int idade;
	    private String curso;

	    public Aluno(Long id, String nome, int idade, String curso) {
	        this.id = id;
	        this.nome = nome;
	        this.idade = idade;
	        this.curso = curso;
	    }

	    
	    public Aluno() {
	        this.id = 0L;
	        this.nome = "";
	        this.idade = 0;
	        this.curso = "";
	    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nome;
//    private int idade;
//    private String curso;
//    
//    public Aluno(int id, String nome, int idade, String curso) {
//        this.id = (long) id;
//        this.nome = nome;
//        this.idade = idade;
//        this.curso = curso;
//    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

    // construtores, getters e setters
	
	@Override
	public String toString() {
	    return "Aluno [id=" + id + ", nome=" + nome + ", idade=" + idade + ", curso=" + curso + "]";
	}


    
}

