package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.AluguelDeCarros;
import models.entities.Veiculo;
import models.services.ServicoAluguel;
import models.services.ServicoFiscalBrasil;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* Programa em java para treinamento de Interfaces e Classes do tipo serviços */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Dados do aluguel: ");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Entrada (dd/MM/yyyy HH:mm:ss): ");
		Date entrada = sdf.parse(sc.nextLine());
		System.out.print("Saída (dd/MM/yyyy HH:mm:ss): ");
		Date saida = sdf.parse(sc.nextLine());
		
		AluguelDeCarros aluguelDeCarros = new AluguelDeCarros(entrada, saida, new Veiculo(modeloCarro));
		
		System.out.print("Preço por hora: ");
		Double precoPorHora = sc.nextDouble();
		System.out.print("Preço por dia: ");
		Double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new ServicoFiscalBrasil());
		
		servicoAluguel.processarFatura(aluguelDeCarros);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento basico: " + aluguelDeCarros.getFatura().getPagamentoBase());
		System.out.println("Imposto: " + aluguelDeCarros.getFatura().getImposto());
		System.out.println("Pagamento Total: "+ aluguelDeCarros.getFatura().getPagamentoTotal());
		
		sc.close();
		
	}

}
