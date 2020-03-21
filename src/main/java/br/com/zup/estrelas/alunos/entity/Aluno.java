package br.com.zup.estrelas.alunos.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Aluno {
	
	@Id
	private long matricula;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "data_nascimento", nullable = false)
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNacimento;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private float valorMensalidade;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(LocalDate dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(float valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	

}
