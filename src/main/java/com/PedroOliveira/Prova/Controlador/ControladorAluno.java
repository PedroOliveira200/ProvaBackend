package com.PedroOliveira.Prova.Controlador;

import com.PedroOliveira.Prova.entities.Aluno;
import com.PedroOliveira.Prova.Servicos.ServicoAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/aluno")
public class ControladorAluno {

	@Autowired
    private ServicoAluno alunoService;

    // Recuperar todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos(@RequestParam int page, @RequestParam int size) {
        return alunoService.getAllAlunos(page, size).getContent();
    }

    // Recuperar aluno por id
    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    // Criar um novo aluno
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno createAluno(@RequestBody @Validated Aluno aluno) {
        return alunoService.createAluno(aluno);
    }

    // Atualizar aluno
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody @Validated Aluno aluno) {
        return alunoService.updateAluno(id, aluno);
    }

    // Remover aluno
    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
	
}
