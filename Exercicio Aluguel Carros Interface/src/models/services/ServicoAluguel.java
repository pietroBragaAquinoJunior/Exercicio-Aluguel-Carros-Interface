package models.services;

import models.entities.AluguelDeCarros;
import models.entities.Fatura;

public class ServicoAluguel {

	private Double precoPorDia;
	private Double precoPorHora;
	private ServicoFiscal impostoBrasil;
	
	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ServicoFiscal impostoBrasil) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoBrasil = impostoBrasil;
	}
	
	public void processarFatura(AluguelDeCarros aluguelDeCarros) {
		
		double horas = (double) (aluguelDeCarros.getFim().getTime() - aluguelDeCarros.getInicio().getTime()) /1000 / 60 / 60;
		double pagamentoBase;
		
		if(horas <=12.0) {
			pagamentoBase = Math.ceil(horas) * precoPorHora;
		} else {
			pagamentoBase = Math.ceil(horas /24) * precoPorDia;
		}
		
		double imposto = impostoBrasil.imposto(pagamentoBase);
		
		aluguelDeCarros.setFatura(new Fatura(pagamentoBase, imposto));
	}
	
}
