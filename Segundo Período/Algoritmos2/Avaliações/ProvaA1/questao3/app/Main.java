package questao3.app;
import java.util.Scanner;
import questao3.modelo.Bebida;

public class Main {
	public static void main(String[] args) {
		Bebida[] bebida = new Bebida[9];
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < bebida.length; i++) {
			System.out.println("Bebida " + (i+1));
			bebida[i] = Bebida.lerDados();
		}
		
		Bebida.imprimirBebidaMaisCara(bebida);
	}
}
