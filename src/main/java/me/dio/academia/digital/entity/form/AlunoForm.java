package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class AlunoForm {

  private String nome;
  
  @NotBlank(message = "preencha este campo")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
  @CPF(message = "'${validatedValue}' e invalido")
  private String cpf;

  @NotBlank(message = "preencha este campo")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
  private String bairro;

  @NotNull(message = "preencha este campo")
  @Past(message = "'${validadeValue}' e invalido")
  private LocalDate dataDeNascimento;

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public LocalDate getDataDeNascimento() {
	return dataDeNascimento;
}

public void setDataDeNascimento(LocalDate dataDeNascimento) {
	this.dataDeNascimento = dataDeNascimento;
}
  
  
}
