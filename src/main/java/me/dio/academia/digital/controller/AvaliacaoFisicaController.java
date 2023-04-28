package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	private AvaliacaoFisicaServiceImpl service;
	 
	@Autowired
	private AvaliacaoFisicaRepository avRepository;
	
	@GetMapping
	public List<AvaliacaoFisica> getAvaliacaoFisica() {
		
		return service.getAll();
	}
	
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	@PutMapping(value = "atualizarAvaliacao")
	public ResponseEntity<?> atualizar(@RequestBody AvaliacaoFisica avFisica){
		if(avFisica.getId() == null) {
			return new ResponseEntity<String>("O id do usuário não foi informado!", HttpStatus.OK);
		}
		AvaliacaoFisica av = avRepository.saveAndFlush(avFisica);
		return new ResponseEntity<AvaliacaoFisica>(av, HttpStatus.OK);
	}
}
