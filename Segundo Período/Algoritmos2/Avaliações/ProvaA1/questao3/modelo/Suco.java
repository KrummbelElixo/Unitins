package questao3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Suco extends Bebida {
	private String fruta;
	private boolean sucoNatural;

	
	
	public Suco(String nome, String fruta) {
		super(nome);
		this.fruta = fruta;
	}

	public Suco(String nome, String fruta, boolean sucoNatural, LocalDate dataCompra, Float valor) {
		super(nome, dataCompra, valor);
		this.fruta = fruta;
		this.sucoNatural = sucoNatural;
	}

	public String getFruta() {
		return fruta;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	public boolean isSucoNatural() {
		return sucoNatural;
	}

	public void setSucoNatural(boolean sucoNatural) {
		this.sucoNatural = sucoNatural;
	}
	
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Fruta: " + this.fruta);
		System.out.println("É natural? " + (this.sucoNatural ? "Sim" : "Não"));
	}
	
	public static Suco lerDados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Data compra (DIA/MES/ANO)");
		String dataCompra = scanner.next();
		System.out.println("Valor da bebida:");
		float valor = scanner.nextFloat();
		System.out.println("Informe a Fruta:");
		String fruta = scanner.next();
		System.out.println("É natural?");
		System.out.println("[1] - Sim");
		System.out.println("[2] - Não");
		boolean natural = scanner.nextInt() == 1;
		
		LocalDate dataFormatada = LocalDate.parse(dataCompra, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Suco suco = new Suco(nome, fruta, natural, dataFormatada, valor);
		return suco;
	}
}
