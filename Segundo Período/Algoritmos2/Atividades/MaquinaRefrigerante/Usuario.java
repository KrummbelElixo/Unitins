import java.util.Scanner;

public class Usuario {
	private String nome;
	private float saldo;
	
	Usuario (String nome, float saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if(saldo > 0f) {
			this.saldo -= saldo;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public void adicionarFundos() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira a quantia que deseja adicionar");
		this.saldo += scanner.nextFloat();
		
		if(this.saldo > 0f) {
			System.out.println("Saldo adicionado com sucesso!");
			System.out.printf("Agora você tem R$%.2f na sua conta\n", this.saldo);
			System.out.println("Digite qualquer tecla para continuar...");
			scanner.next();
		} else {
			System.out.println("Saldo inválido!");
			this.saldo = 0f;
		}
	}
	
	public void retirarTroco() {
		this.saldo -= this.saldo;
	}
}
