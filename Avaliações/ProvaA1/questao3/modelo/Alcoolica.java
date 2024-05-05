package questao3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Alcoolica extends Bebida {
	private Integer teorAlcoolico;
	private	Integer idade;
		
	public Alcoolica(String nome, Integer teorAlcoolico) {
		super(nome);
		this.teorAlcoolico = teorAlcoolico;
	}

	public Alcoolica(String nome, Integer teorAlcoolico, Integer idade, LocalDate dataCompra, Float valor) {
		super(nome, dataCompra, valor);
		this.teorAlcoolico = teorAlcoolico;
		this.idade = idade;
	}

	public Integer getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(Integer teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Teor Alcoolico: " + this.teorAlcoolico + "%");
		System.out.println("Idade: " + this.idade);
	}
	
	public static Alcoolica lerDados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Data compra (DIA/MES/ANO)");
		String dataCompra = scanner.next();
		System.out.println("Valor da bebida:");
		float valor = scanner.nextFloat();
		System.out.println("Teor alcoolico da bebida (NUMERO)");
		int teorAlcoolico = scanner.nextInt();
		System.out.println("Idade da bebida:");
		int idade = scanner.nextInt();
		
		LocalDate dataFormatada = LocalDate.parse(dataCompra, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Alcoolica alcool = new Alcoolica(nome, teorAlcoolico, idade, dataFormatada, valor);
		
		return alcool;
	}
}
