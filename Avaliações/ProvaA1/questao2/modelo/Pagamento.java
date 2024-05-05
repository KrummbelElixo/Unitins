package questao2.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Pagamento {
	private String formaPagamento;
	private Float valor;
	private Float multa;
	private LocalDate dataVencimento;
	
	public Pagamento(String formaPagamento, Float valor) {
		super();
		this.formaPagamento = formaPagamento;
		this.valor = valor;
	}

	public Pagamento(String formaPagamento, Float valor, Float multa, LocalDate dataVencimento) {
		super();
		this.formaPagamento = formaPagamento;
		this.valor = valor;
		this.multa = multa;
		this.dataVencimento = dataVencimento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getMulta() {
		return multa;
	}

	public void setMulta(Float multa) {
		this.multa = multa;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.valor, this.multa, this.formaPagamento, this.dataVencimento);
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Pagamento) {
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
		return "Forma de pagamento: " + this.formaPagamento + " valor: " + this.valor + 
				" multa: " + this.multa + " Data de Vencimento: " + this.dataVencimento;
	}
}
