package br.com.infnet.CrudAlunoDevops;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.infnet.CrudAlunoDevops.model.Aluno;
import br.com.infnet.CrudAlunoDevops.repository.AlunoRepository;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


	@SpringBootTest
	@AutoConfigureTestDatabase
	@AutoConfigureMockMvc
	public class CrudAlunoDevopsApplicationTests {
		
		private Logger logger = LoggerFactory.getLogger(CrudAlunoDevopsApplicationTests.class);
		
//	    @Autowired
//	    private AlunoRepository alunoRepository;
//	    
//	    @Autowired
//	    private MockMvc mockMvc;
//
//	    
//	   
//
//	    @Test
//	    public void testListaDeAlunos() throws Exception {
//	        MvcResult result = mockMvc.perform(get("/alunos"))
//	                .andExpect(status().isOk())
//	                .andReturn();
//	        int status = result.getResponse().getStatus();
//	        assertEquals(200, status);
//
//	        String content = result.getResponse().getContentAsString();
//	        List<Aluno> listaDeAlunos = new ObjectMapper().readValue(content, new TypeReference<List<Aluno>>() {});
//	        assertEquals(10, listaDeAlunos.size());
//
//	        Aluno aluno = new Aluno(1L, "João", 20, "Engenharia");
//	        System.out.println(aluno);
//	        
//	       
//
//	    }

	    

//	    private void assertEquals(int i, int status) {
//	    }

	    
		

		

	}	 

		


		    



//package br.com.infnet.CrudAlunoDevops;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//
//import br.com.infnet.CrudAlunoDevops.model.Aluno;
//import br.com.infnet.CrudAlunoDevops.repository.AlunoRepository;
//
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@AutoConfigureTestDatabase
//@AutoConfigureMockMvc
//class CrudAlunoDevopsApplicationTests {
//
////	@SpringBootTest
////	@AutoConfigureTestDatabase
////	public class AlunoControllerTest {
//	    @Autowired
//	    private AlunoRepository alunoRepository;
//	    
////	    
//
//	    @Test
//	    public void testListarAlunos() throws Exception {
//	        Aluno aluno1 = new Aluno(0, "João", 20, "Engenharia");
//	        alunoRepository.save(aluno1);
//
//	        Aluno aluno2 = new Aluno(0, "Maria", 22, "Direito");
//	        alunoRepository.save(aluno2);
//
//	        mockMvc.perform(get("/alunos"))
//	                .andExpect(status().isOk())
//	                .andExpect(jsonPath("$", hasSize(2)))
//	                .andExpect(jsonPath("$[0].nome", is("João")))
//	                .andExpect(jsonPath("$[0].idade", is(20)))
//	                .andExpect(jsonPath("$[0].curso", is("Engenharia")))
//	                .andExpect(jsonPath("$[1].nome", is("Maria")))
//	                .andExpect(jsonPath("$[1].idade", is(22)))
//	                .andExpect(jsonPath("$[1].curso", is("Direito")));
//	    }
//
//	    @Test
//	    public void testBuscarAlunoPorId() throws Exception {
//	        Aluno aluno = new Aluno(0, "João", 20, "Engenharia");
//	        alunoRepository.save(aluno);
//
//	        mockMvc.perform(get("/alunos/{id}", aluno.getId()))
//	                .andExpect(status().isOk())
//	                .andExpect(jsonPath("$.nome", is("João")))
//	                .andExpect(jsonPath("$.idade", is(20)))
//	                .andExpect(jsonPath("$.curso", is("Engenharia")));
//	    }
//
//	    @Test
//	    public void testInserirAluno() throws Exception {
//	        Aluno aluno = new Aluno(0, "João", 20, "Engenharia");
//
//	        mockMvc.perform(post("/alunos")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(objectMapper.writeValueAsString(aluno)))
//	                .andExpect(status().isCreated())
//	                .andExpect(jsonPath("$.nome", is("João")))
//	                .andExpect(jsonPath("$.idade", is(20)))
//	                .andExpect(jsonPath("$.curso", is("Engenharia")));
//
//	        List<Aluno> alunos = alunoRepository.findAll();
//	        assertThat(alunos).hasSize(1);
//	        assertThat(alunos.get(0)).isEqualToIgnoringGivenFields(aluno, "id");
//	    }
//
//	    @Test
//	    public void testAtualizarAluno() throws Exception {
//	        Aluno aluno = new Aluno(0, "João", 20, "Engenharia");
//	        alunoRepository.save(aluno);
//
//	        Aluno alunoAtualizado = new Aluno(0, "Maria", 22, "Direito");
//
//	        mockMvc.perform(put("/alunos/{id}", aluno.getId())
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(objectMapper.writeValueAsString(alunoAtualizado)))
//	                .andExpect(status().isOk())
//	                .andExpect(jsonPath("$.nome", is("Maria")))
//	                .andExpect(jsonPath("$.idade", is(22)))
//	                .andExpect(jsonPath("$.curso", is("Direito")));
//
//	        Aluno alunoExistente = alunoRepository.findById(aluno.getId()).orElse(null);
//	        assertThat(alunoExistente).isNotNull();
//	        assertThat(alunoExistente.getNome()).isEqualTo("Maria");
//	        assertThat(alunoExistente.getIdade()).isEqualTo(22);
//	       
//
//
//}
//}
