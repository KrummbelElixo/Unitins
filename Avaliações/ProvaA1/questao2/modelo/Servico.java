package questao2.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Servico {
	private LocalDate diaInicio;
	private LocalDate terminoPrevisto;
	private LocalDate diaTermino;
	private Float orcamento;
	private Pagamento[] pagamento;
	
	public Servico(LocalDate diaInicio, LocalDate terminoPrevisto, Float orcamento) {
		super();
		this.diaInicio = diaInicio;
		this.terminoPrevisto = terminoPrevisto;
		this.orcamento = orcamento;
	}

	public Servico(LocalDate diaInicio, LocalDate terminoPrevisto, LocalDate diaTermino, Float orcamento,
			Pagamento[] pagamento) {
		super();
		this.diaInicio = diaInicio;
		this.terminoPrevisto = terminoPrevisto;
		this.diaTermino = diaTermino;
		this.orcamento = orcamento;
		this.pagamento = pagamento;
	}

	public LocalDate getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(LocalDate diaInicio) {
		this.diaInicio = diaInicio;
	}

	public LocalDate getTerminoPrevisto() {
		return terminoPrevisto;
	}

	public void setTerminoPrevisto(LocalDate terminoPrevisto) {
		this.terminoPrevisto = terminoPrevisto;
	}

	public LocalDate getDiaTermino() {
		return diaTermino;
	}

	public void setDiaTermino(LocalDate diaTermino) {
		this.diaTermino = diaTermino;
	}

	public Float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Float orcamento) {
		this.orcamento = orcamento;
	}

	public Pagamento[] getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento[] pagamento) {
		this.pagamento = pagamento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.diaInicio, this.diaInicio, this.orcamento, this.terminoPrevisto);
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Servico) {
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
		return "dia que inicia: " + this.diaInicio + " termino previso: " + this.terminoPrevisto +
				" orçamento: " + this.orcamento + " pagamento:" + this.pagamento.toString();
	}
}
