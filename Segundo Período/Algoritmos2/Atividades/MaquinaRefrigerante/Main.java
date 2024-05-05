public class Main {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("Consumidor", 0f);
		MaquinaRefrigerante maquina = new MaquinaRefrigerante(usuario);
		
		maquina.iniciar();
		
		System.out.println("Programa desenvolvido por Gustavo Oliveira da Silva");
		System.out.println("Aluno do Segundo Período de SI");
	}
}
