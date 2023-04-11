package br.com.infnet.CrudAlunoDevops.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.infnet.CrudAlunoDevops.model.Aluno;
import br.com.infnet.CrudAlunoDevops.repository.AlunoRepository;
import br.com.infnet.CrudAlunoDevops.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private final AlunoRepository alunoRepository;
    
    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    

    @GetMapping("/{alunoId}")
    public Aluno getAluno(@PathVariable String alunoId) {
        String alunoUrl = String.format(environment.getProperty("alunos.url"), alunoId);
        ResponseEntity<Aluno> alunoResponse = restTemplate.exchange(alunoUrl, HttpMethod.GET, null, Aluno.class);
        return alunoResponse.getBody();
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    
   

//    @PostMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Aluno inserir(@RequestBody Aluno aluno) {
//        return alunoRepository.save(aluno);
//    }
//    
 
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno inserir(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            Aluno alunoExistente = aluno.get();
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setIdade(alunoAtualizado.getIdade());
            alunoExistente.setCurso(alunoAtualizado.getCurso());
            alunoRepository.save(alunoExistente);
            return ResponseEntity.ok(alunoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            alunoRepository.delete(aluno.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   

}

