package br.com.infnet.CrudAlunoDevops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.CrudAlunoDevops.model.Aluno;
import br.com.infnet.CrudAlunoDevops.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    // restante do código

	public static Aluno save(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}


}

