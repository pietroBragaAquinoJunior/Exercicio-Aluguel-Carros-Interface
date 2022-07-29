package models.services;

public class ServicoFiscalBrasil implements ServicoFiscal {

	public Double imposto(Double valor) {
		if(valor <= 100.0) {
			return valor * 0.20;
		}else {
			return valor * 0.15;
		}
	}
	
}
