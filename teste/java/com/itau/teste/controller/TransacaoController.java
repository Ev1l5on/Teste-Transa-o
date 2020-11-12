package com.itau.teste.controller;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itau.teste.model.Transacao;
@RestController
@CrossOrigin("*")
@RequestMapping("/transacao")
public class TransacaoController {
	
	private List<Transacao> repository = Transacao.getService();
	
	@GetMapping
	public ResponseEntity<List<Transacao>> getAll(){
		return ResponseEntity.ok(repository);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<List<Transacao>> post(@RequestBody Transacao transacao){
		
		if (transacao.getValor() < 0 || transacao.getDataHora().isAfter(OffsetDateTime.now())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}
		repository.add(transacao);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
		
	}
	
	@DeleteMapping
	public ResponseEntity<Transacao> delete(){
		repository.clear();
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
