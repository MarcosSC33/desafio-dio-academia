package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	@Autowired
	private AlunoRepository aRepository;
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
		return service.getAllAvaliacao(id);
	}
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataNascimento", required = false) String dataNascimento){
		return service.getAll(dataNascimento);
	}
	
	@PutMapping(value = "atualizar")
	public ResponseEntity<?> atualizar(@RequestBody Aluno aluno){
		if(aluno.getId() == null) {
			return new ResponseEntity<String>("O id do usuário não foi informado!", HttpStatus.OK);
		}
		Aluno user = aRepository.saveAndFlush(aluno);
		return new ResponseEntity<Aluno>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete")
	public ResponseEntity<String> delete(@RequestParam Long id){
		aRepository.deleteById(id);
		return new ResponseEntity<String>("Usuario"+" "+id+" "+"deletado com sucesso!", HttpStatus.OK);
	}
	
}
