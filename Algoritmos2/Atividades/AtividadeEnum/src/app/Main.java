package app;

import java.util.Scanner;
import modelo.Pagamento;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas compras irá cadastrar?");
        int qntCompras = scanner.nextInt();
        Pagamento[] pag = new Pagamento[qntCompras];

        for(int i = 0; i < pag.length; i++) {
            pag[i] = Pagamento.lerDados();
            System.out.println();
            System.out.println("Compra cadastrada!");
            System.err.println(pag[i]);
            System.out.println();
        }

        System.out.println();
        Pagamento.imprimirDados(pag);
        System.out.println();
        Pagamento.imprimirPagamentoMaisBarato(pag);
        System.out.println();
        Pagamento.imprimirPagamentoMaisCaro(pag);

        scanner.close();
    }
}
