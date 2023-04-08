package br.com.infnet.CrudAlunoDevops.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import br.com.infnet.CrudAlunoDevops.model.Aluno;

public class AlunoTest {

    @Test
    public void testCriacaoDeAluno() {
        Aluno aluno = new Aluno(1L, "João", 20, "Engenharia");
        assertEquals("João", aluno.getNome());
        assertEquals(20, aluno.getIdade());
        assertEquals("Engenharia", aluno.getCurso());
    }

    


}

