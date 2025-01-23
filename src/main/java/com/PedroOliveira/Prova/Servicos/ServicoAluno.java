package com.PedroOliveira.Prova.Servicos;

import com.PedroOliveira.Prova.entities.Aluno;
import com.PedroOliveira.Prova.Repositorio.RepositorioAluno;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class ServicoAluno {	

	 @Autowired
	    private RepositorioAluno repositorioAluno;

	    
	    public Page<Aluno> getAllAlunos(int page, int size) {
	        return repositorioAluno.findAll(PageRequest.of(page, size));
	    }

	    
	    public Aluno getAlunoById(Long id) {
	        Optional<Aluno> aluno = repositorioAluno.findById(id);
	        if (aluno.isEmpty()) {
	            throw new RuntimeException("Aluno não encontrado");
	        }
	        return aluno.get();
	    }

	    // Criar um novo aluno
	    public Aluno createAluno(@Validated Aluno aluno) {
	        return repositorioAluno.save(aluno);
	    }

	    // Atualizar aluno
	    public Aluno updateAluno(Long id,  Aluno aluno) {
	        if (!repositorioAluno.existsById(id)) {
	            throw new RuntimeException("Aluno não encontrado para atualização");
	        }
	        aluno.setId(id);
	        return repositorioAluno.save(aluno);
	    }

	    // Remover aluno
	    public void deleteAluno( Long id) {
	        if (!repositorioAluno.existsById(id)) {
	            throw new RuntimeException("Aluno não encontrado para remoção");
	        }
	        repositorioAluno.deleteById(id);
	    }
	
}
