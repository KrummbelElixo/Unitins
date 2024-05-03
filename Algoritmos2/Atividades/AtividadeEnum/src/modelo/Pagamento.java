package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pagamento {
    private Float valor;
    private Float valorCobrado;
    private Float troco;
    private LocalDate dataCompra;
    private FormaPagamento formaPagamento;

    public Pagamento() {
        
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }   
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Valor enviado: R$").append(this.valor).append("\n")
        .append("Valor cobrado: R$").append(this.valorCobrado).append("\n")
        .append("Troco: R$").append(this.troco).append("\n")
        .append("Forma de pagamento: ").append(this.formaPagamento.getLabel()).append("\n")
        .append("Data da compra: ").append(this.dataCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return builder.toString();
    }

    public static Pagamento lerDados() {
        Scanner scanner = new Scanner(System.in);
        Pagamento pagamento = new Pagamento();
        System.out.println("Informe a quantia enviada:");
        pagamento.setValor(scanner.nextFloat());
        System.out.println("Informe o metodo de pagamento:");
        FormaPagamento.forEach();
        pagamento.setFormaPagamento(FormaPagamento.valueOf(scanner.nextInt()));

        Integer id = pagamento.getFormaPagamento().getId();
        if(id == 1) {
            System.out.println("Informe o valor cobrado");
            pagamento.setValorCobrado(scanner.nextFloat());
            pagamento.setTroco(pagamento.getValor()-pagamento.getValorCobrado());
        } else {
            pagamento.setValorCobrado(pagamento.getValor());
            pagamento.setTroco(0f);
        }

        pagamento.setDataCompra(LocalDate.now());

        return pagamento;
    }

    public static void imprimirDados(Pagamento[] pagamento) {
        for(int i = 0; i < pagamento.length; i++) {
            System.out.println("Pagamento " + (i+1));
            System.out.println(pagamento[i]);
            System.out.println();
        }
    }

    public static void imprimirPagamentoMaisCaro(Pagamento[] pagamento) {
        Pagamento maisCaro = pagamento[0];

        for(int i = 0; i < pagamento.length; i++) {
            if(pagamento[i].getValorCobrado() > maisCaro.getValorCobrado()) {
                maisCaro = pagamento[i];
            }
        }

        System.out.println("Pagamento mais caro:");
        System.out.println(maisCaro);
    }

    public static void imprimirPagamentoMaisBarato(Pagamento[] pagamento) {
        Pagamento maisBarato = pagamento[0];

        for(int i = 0; i < pagamento.length; i++) {
            if(pagamento[i].getValorCobrado() < maisBarato.getValorCobrado()) {
                maisBarato = pagamento[i];
            }
        }

        System.out.println("Pagamento mais barato:");
        System.out.println(maisBarato);
    }
}
