package me.dio.academia.digital.entity;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Matricula {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;
  private LocalDateTime dataDaMatricula = LocalDateTime.now();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Aluno getAluno() {
	return aluno;
}

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public LocalDateTime getDataDaMatricula() {
	return dataDaMatricula;
}

public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
	this.dataDaMatricula = dataDaMatricula;
}
  
}
