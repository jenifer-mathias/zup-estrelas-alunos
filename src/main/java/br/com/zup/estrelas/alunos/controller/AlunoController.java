package br.com.zup.estrelas.alunos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.estrelas.alunos.entity.Aluno;


@RestController

@RequestMapping("/alunos")

public class AlunoController {

	@Autowired
	br.com.zup.estrelas.repository.AlunoRepository repository;

	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.repository.save(aluno);
	}

	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<Aluno> buscaAluno(@PathVariable Long matricula) {
		return repository.findById(matricula);
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Aluno> buscaAlunos() {
	return (List<Aluno>) repository.findAll();
	}
	
	@DeleteMapping(path = "/matricula}")
	public void deletaAluno(@PathVariable Long matricula) {
		repository.deleteById(matricula);
	}
	
}
