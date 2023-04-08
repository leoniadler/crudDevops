package br.com.infnet.CrudAlunoDevops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.CrudAlunoDevops.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Aluno save(Aluno aluno);
}

