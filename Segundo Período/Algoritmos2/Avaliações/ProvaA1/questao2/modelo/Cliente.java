package questao2.modelo;

import java.util.Objects;

public class Cliente {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Celular[] celular;
	
	public Cliente(String nome, String telefone, Celular[] celular) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Cliente(String nome, String cpf, String email, String telefone, Celular[] celular) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Celular[] getCelular() {
		return celular;
	}

	public void setCelular(Celular[] celular) {
		this.celular = celular;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.cpf, this.email, this.telefone);
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Cliente) {
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
		return "Nome: " + this.nome + " CPF: " + this.cpf + " email: " + this.email + " telefone: " + this.telefone;
	}
}
