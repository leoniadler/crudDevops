package br.com.infnet.CrudAlunoDevops;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.core.IsInstanceOf.instanceOf;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.infnet.CrudAlunoDevops.controller.AlunoController;
import br.com.infnet.CrudAlunoDevops.model.Aluno;
import br.com.infnet.CrudAlunoDevops.repository.AlunoRepository;
import br.com.infnet.CrudAlunoDevops.service.AlunoService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoRepository alunoRepository;

    @Test
    public void testListar() throws Exception {
        Aluno aluno1 = new Aluno(1L, "João", 20, "Engenharia");
        Aluno aluno2 = new Aluno(2L, "Maria", 21, "Medicina");
        List<Aluno> alunos = Arrays.asList(aluno1, aluno2);
        
        given(alunoRepository.findAll()).willReturn(alunos);

        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome", is("João")))
                .andExpect(jsonPath("$[0].idade", is(20)))
                .andExpect(jsonPath("$[0].curso", is("Engenharia")))
                .andExpect(jsonPath("$[1].nome", is("Maria")))
                .andExpect(jsonPath("$[1].idade", is(21)))
                .andExpect(jsonPath("$[1].curso", is("Medicina")));
    }

    @Test
    public void testBuscarPorId() throws Exception {
        Aluno aluno = new Aluno(1L, "João", 20, "Engenharia");

        given(alunoRepository.findById(1L)).willReturn(Optional.of(aluno));

        mockMvc.perform(get("/alunos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("João")))
                .andExpect(jsonPath("$.idade", is(20)))
                .andExpect(jsonPath("$.curso", is("Engenharia")));
    }

    @Test
    public void testBuscarPorIdNaoExistente() throws Exception {
        given(alunoRepository.findById(1L)).willReturn(Optional.empty());

        mockMvc.perform(get("/alunos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testInserir() throws Exception {
        Aluno aluno = new Aluno(1L, "João", 20, "Engenharia");

        given(alunoRepository.save(aluno)).willReturn(aluno);

        mockMvc.perform(post("/alunos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": 1, \"nome\": \"João\", \"idade\": 20, \"curso\": \"Engenharia\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("João")))
                .andExpect(jsonPath("$.idade", is(20)))
                .andExpect(jsonPath("$.curso", is("Engenharia")));
    }
    
    
//    @PostMapping(produces = "application/json")
//    public Aluno save(@RequestBody Aluno aluno) {
//        
//        return AlunoService.save(aluno);
//    }
    
//    @Test
//    public void testInserir() throws Exception {
//        Aluno aluno = new Aluno(1L, "João", 20, "Engenharia");
//
//        // Mock the behavior of the save method to return the expected Aluno object
//        when(alunoRepository.save(any())).thenReturn(aluno);
//
//        mockMvc.perform(post("/alunos")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"id\": 1, \"nome\": \"João\", \"idade\": 20, \"curso\": \"Engenharia\" }"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.nome", is("João")))
//                .andExpect(jsonPath("$.idade", is(20)))
//                .andExpect(jsonPath("$.curso", is("Engenharia")));
//
//        // Verify that the save method of the repository was called with the expected object
//        verify(alunoRepository, times(1)).save(aluno);
//    }


    @Test
    public void testAtualizar() throws Exception {
        Aluno alunoExistente = new Aluno(1L, "João", 20, "Engenharia");
        Aluno alunoAtualizado = new Aluno(1L, "Pedro", 21, "Administração");

        given(alunoRepository.findById(1L)).willReturn(Optional.of(alunoExistente));
        given(alunoRepository.save(alunoExistente)).willReturn(alunoAtualizado);

        mockMvc.perform(put("/alunos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": 1, \"nome\": \"Pedro\", \"idade\": 21, \"curso\": \"Administração\" }"))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.nome", is("Pedro")))
            .andExpect(jsonPath("$.idade", is(21)))
            .andExpect(jsonPath("$.curso", is("Administração")));
    



	    

	   
	       
    }

}
		    
