package questao3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Energetico extends Bebida {
	private Integer teorEnergetico;
	private boolean possuiAlcool;
	
	public Energetico(String nome, Integer teorEnergetico) {
		super(nome);
		this.teorEnergetico = teorEnergetico;
	}

	public Energetico(String nome, Integer teorEnergetico, boolean possuiAlcool, LocalDate dataCompra, Float valor) {
		super(nome, dataCompra, valor);
		this.teorEnergetico = teorEnergetico;
		this.possuiAlcool = possuiAlcool;
	}

	public Integer getTeorEnergetico() {
		return teorEnergetico;
	}

	public void setTeorEnergetico(Integer teorEnergetico) {
		this.teorEnergetico = teorEnergetico;
	}

	public boolean isPossuiAlcool() {
		return possuiAlcool;
	}

	public void setPossuiAlcool(boolean possuiAlcool) {
		this.possuiAlcool = possuiAlcool;
	}
	
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Teor Energetico: " + this.teorEnergetico + "%");
		System.out.println("Possui alcool: " + (this.possuiAlcool ? "Sim" : "Não"));
	}
	
	public static Energetico lerDados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Data compra (DIA/MES/ANO)");
		String dataCompra = scanner.next();
		System.out.println("Valor da bebida:");
		float valor = scanner.nextFloat();
		System.out.println("Teor Energetico (NUMERO)");
		int teorEnergetico = scanner.nextInt();
		System.out.println("Possui alcool?");
		System.out.println("[1] - Sim");
		System.out.println("[2] - Não");
		boolean alcool = scanner.nextInt() == 1;
		
		LocalDate dataFormatada = LocalDate.parse(dataCompra, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Energetico energetico = new Energetico(nome, teorEnergetico, alcool, dataFormatada, valor);
		return energetico;
	}
}
