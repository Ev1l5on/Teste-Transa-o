package com.itau.teste.controller;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.teste.model.Transacao;

@RestController
@CrossOrigin("*")
@RequestMapping("/estatistica")
public class EstatisticaController {
	
	private List<Transacao> repository = Transacao.getService();

	@GetMapping
	public ResponseEntity<DoubleSummaryStatistics> get(){
		DoubleSummaryStatistics resultado = new DoubleSummaryStatistics();
		
		for(Transacao min : repository) {
            if(min.getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1))) {
                resultado.accept(min.getValor());
            }
        }
		
		return ResponseEntity.status(HttpStatus.OK).body(resultado);
	}
}
