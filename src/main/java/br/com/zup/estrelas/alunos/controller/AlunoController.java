package br.com.zup.estrelas.alunos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @PostMapping
    public List<Aluno> insereAluno(@RequestBody List<Aluno> alunos) {
        return (List<Aluno>) this.repository.saveAll(alunos);
    }

    @GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Aluno> buscaAluno(@PathVariable Long matricula) {
        return repository.findById(matricula);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Aluno> buscaAlunos() {
        return (List<Aluno>) repository.findAll();
    }

    @PutMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Aluno modificaAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {

        Aluno alunoBanco = repository.findById(matricula).get();

        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setDataNascimento(aluno.getDataNascimento());
        alunoBanco.setValorMensalidade(aluno.getValorMensalidade());

        return this.repository.save(alunoBanco);
    }

    @DeleteMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deletaAluno(@PathVariable Long matricula) {
        this.repository.deleteById(matricula);
    }

    @PatchMapping(path = "/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Aluno> buscaPorCpf(@PathVariable String cpf) {
        return repository.findByCpf(cpf);
    }

}
