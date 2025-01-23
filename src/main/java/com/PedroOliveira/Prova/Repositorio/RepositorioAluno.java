package com.PedroOliveira.Prova.Repositorio;

import com.PedroOliveira.Prova.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAluno extends JpaRepository<Aluno, Long> {
}