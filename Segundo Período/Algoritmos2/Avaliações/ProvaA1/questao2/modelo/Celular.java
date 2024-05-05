package questao2.modelo;

import java.util.Objects;

public class Celular {
	private String marca;
	private String modelo;
	private String tipoTela;
	private String processador;
	
	public Celular(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public Celular(String marca, String modelo, String tipoTela, String processador) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tipoTela = tipoTela;
		this.processador = processador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoTela() {
		return tipoTela;
	}

	public void setTipoTela(String tipoTela) {
		this.tipoTela = tipoTela;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.marca, this.tipoTela, this.processador, this.modelo);
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Celular) {
			if(this.hashCode() == obj.hashCode()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Marca: " + this.marca + " Modelo: " + this.modelo + " Tipo da Tela: " + this.tipoTela +
				" Processador: " + this.processador;
	}
}
