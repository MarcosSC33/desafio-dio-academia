package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MatriculaForm {

  @NotNull(message = "preencha este campo")
  @Positive(message = "O ID do aluno deve ser positivo")
  private Long alunoId;
public Long getAlunoId() {
	return alunoId;
}

public void setAlunoId(Long alunoId) {
	this.alunoId = alunoId;
}

  
}
