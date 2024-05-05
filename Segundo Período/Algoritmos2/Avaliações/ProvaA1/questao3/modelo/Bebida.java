package questao3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bebida {
	private String nome;
	private LocalDate dataCompra;
	private Float valor;
	
	public Bebida(String nome) {
		super();
		this.nome = nome;
	}

	public Bebida(String nome, LocalDate dataCompra, Float valor) {
		super();
		this.nome = nome;
		this.dataCompra = dataCompra;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public void imprimir() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Data compra: " + this.dataCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Valor: R$" + this.valor);
	}

	public static Bebida lerDados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de bebidas");
		System.out.println("Tipo de bebida");
		System.out.println("[1] - Alcoolica");
		System.out.println("[2] - Energetico");
		System.out.println("[3] - Suco");
		int escolha = scanner.nextInt();
		
		if(escolha == 1) {
			return Alcoolica.lerDados();
		} else if (escolha == 2) {
			return Energetico.lerDados();
		} else if (escolha == 3) {
			return Suco.lerDados();
		} else {
			System.out.println("Selecione uma opção válida!");
			return lerDados();
		}
	}
	
	public static void imprimirBebidaMaisCara(Bebida[] vet) {
		Bebida maisCara;
		maisCara = vet[0];
		for(int i = 0; i < vet.length; i++) {
			if(vet[i].getValor() > maisCara.getValor()) {
				maisCara = vet[i];
			}
		}
		System.out.println();
		System.out.println("Bebida mais cara:");
		maisCara.imprimir();
	}
}
