package com.itau.teste.model;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacao {
	
	private double valor;
	private OffsetDateTime dataHora;
	private static List<Transacao> service;

	public static List<Transacao> getService() {
		if(service == null) {
			service = new ArrayList<>();
		}
		return service;
	}

	public static void setService(List<Transacao> service) {
		Transacao.service = service;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
