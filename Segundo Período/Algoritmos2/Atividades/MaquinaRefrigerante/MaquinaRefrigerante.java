import java.util.Scanner;

public class MaquinaRefrigerante {
	private String nome;
	private int estoque;
	private float valor;
	private Usuario usuario;
		
	MaquinaRefrigerante(Usuario usuario) {
		this.usuario = usuario;
	}
	
	MaquinaRefrigerante(String nome, float valor, int estoque) {
		this.setNome(nome);
		this.setEstoque(estoque);
		this.setValor(valor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void removerDoEstoque(int quantidade) {
		if(this.estoque > 0) {
			this.estoque -= quantidade;
		} else {
			System.out.println("Produto não disponivel!");
		}
	}
	
	public void iniciar() {
		Scanner scanner = new Scanner(System.in);
		MaquinaRefrigerante[] refrigerantes = new MaquinaRefrigerante[5];
		//Refrigerantes Disponíveis
		refrigerantes[0] = new MaquinaRefrigerante("Coca-cola", 8.5f, 5);
		refrigerantes[1] = new MaquinaRefrigerante("Fanta Uva", 8.99f, 5);
		refrigerantes[2] = new MaquinaRefrigerante("Fanta Laranja", 8.99f, 5);	
		refrigerantes[3] = new MaquinaRefrigerante("Guarana Jesus", 7.89f, 10);
		refrigerantes[4] = new MaquinaRefrigerante("Pepsi", 9.99f, 10);
		
		boolean programa = true;
		
		while (programa) {
			exibirMenu(usuario.getSaldo());
			int escolha = scanner.nextInt();
			
			switch (escolha) {
				case 1:
					verRefrigerantes(refrigerantes, scanner);
					confirmar(scanner);
				break;
				
				case 2:
					verRefrigerantes(refrigerantes, scanner);
					comprarRefrigerantes(refrigerantes, usuario, scanner);
				break;
					
				case 3:
					usuario.adicionarFundos();
				break;
				
				case 4:
					System.out.println("Encerrando...");
					programa = false;
				break;
			}
					
		}
	}
	
	public static void exibirMenu(float saldo) {
		System.out.println("HyperBlast 2000 Menu");
		System.out.println("[1] - Ver refrigerantes");
		System.out.println("[2] - Comprar refrigerantes");
		System.out.println("[3] - Adicionar saldo");
		System.out.println("[4] - Encerrar");
		System.out.println("================================");
		System.out.println("Carteira: R$" + saldo);
	}
	
	public void visualizarRefrigerante() {
		System.out.println("================================");
		System.out.println(this.nome);
		System.out.println("R$" + this.valor);
		System.out.println("Estoque: " + this.estoque);
		System.out.println("================================");
	}
	
	public static void verRefrigerantes(MaquinaRefrigerante[] refrigerantes, Scanner scanner) {
		System.out.println("================================");
		System.out.println("Menu de bebidas");
				
		for(int i = 0; i < refrigerantes.length; i++) {
			refrigerantes[i].visualizarRefrigerante();
			System.out.println("> Opção " + (i+1));
		}
	}
	
	public static void comprarRefrigerantes(MaquinaRefrigerante[] refrigerantes, Usuario usuario, Scanner scanner) {
		System.out.println("Insira o número do produto que deseja comprar");
		System.out.println("Ou insira 0 para cancelar!");
		int refri = scanner.nextInt()-1;
		
		for(int i = 0; i < refrigerantes.length; i++) {
			if((refri == i) && ((usuario.getSaldo()-refrigerantes[i].getValor()) >= 0)) {
				
				if(refrigerantes[i].getEstoque() > 0) {
					System.out.println("Refrigerante Selecionado: " + refrigerantes[i].getNome());
					System.out.println("Informe a quantidade desejada");
					int quantidade = scanner.nextInt();
					
					float regraDeSaldo = usuario.getSaldo() - (refrigerantes[i].getValor() * (float) quantidade);
					
					while((quantidade > refrigerantes[i].getEstoque()) || (regraDeSaldo < 0f)) {
						System.out.println("A quantidade selecionada, não deve ultrapassar o estoque!");
						System.out.println("ou saldo insuficiente para a quantidade de refris desejada");
						System.out.println("Insira a quantidade novamente");
						quantidade = scanner.nextInt();
						regraDeSaldo = usuario.getSaldo() - (refrigerantes[i].getValor() * (float) quantidade);
					}
					
					refrigerantes[i].removerDoEstoque(quantidade);
					usuario.setSaldo(refrigerantes[i].getValor() * ((float) quantidade));
					notaDePagamentos(usuario, refrigerantes, refri, quantidade);
					confirmar(scanner);
					sistemaDeTroco(usuario, scanner);
				} else {
					System.out.println("Produto indisponível!");
				}
				
			} else if ((refri == i) && ((usuario.getSaldo()-refrigerantes[i].getValor()) < 0)) {
				System.out.println("Falha na compra!");
				System.out.println("Saldo insuficiente");
			}
		}
	}

	public static void sistemaDeTroco(Usuario usuario, Scanner scanner) {
		System.out.printf("O seu troco foi de R$%.2f\n", usuario.getSaldo());
		System.out.println("Deseja retirar ou quer continuar comprando?");
		System.out.println("[1] - Quero retirar o troco");
		System.out.println("[2] - Desejo continuar comprando");
		
		int escolha = scanner.nextInt();
		
		switch (escolha) {
			case 1:
				System.out.println("Troco retirado!");
				usuario.retirarTroco();
			break;
			
			case 2:
				System.out.println("Retornando ao sistemas de compras...");
			break;
			
			default: 
				sistemaDeTroco(usuario, scanner);
			break;
		}
	}
	
	public static void notaDePagamentos(Usuario usuario, MaquinaRefrigerante[] refrigerantes, int refriSelecionado, int quantidade) {
		System.out.println("================================");
		System.out.println("NOTA DE PAGAMENTO");
		System.out.println(refrigerantes[refriSelecionado].getNome() + ". R$" + refrigerantes[refriSelecionado].getValor() + " " + quantidade + "x");
		System.out.println("================================");
		System.out.println("TOTAL A PAGAR: R$" + (refrigerantes[refriSelecionado].getValor() * quantidade));
		System.out.println("================================");
		System.out.println("ESTE PAPEL POSSUI VALOR FISCAL");
	}
	
	public static void confirmar(Scanner scanner) {
		System.out.println("Digite qualquer tecla para continuar...");
		scanner.next();
	}
}
