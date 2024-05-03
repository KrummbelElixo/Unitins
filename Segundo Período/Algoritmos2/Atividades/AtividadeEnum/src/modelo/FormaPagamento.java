package modelo;

public enum FormaPagamento {
    DINHEIRO (1, "Dinheiro"),
    CARTAO (2, "Cartão"),
    VALEALIMENTACAO (3, "Vale Alimentação"),
    PIX (4, "Pix"),
    MERCADOPAGO (5, "Mercado Pago"),
    PAYPAL (6, "PayPal");

    FormaPagamento(int id, String label) {
        this.id = id;
        this.label = label;
    }

    private final int id;
    private final String label;

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static void forEach() {
        for(FormaPagamento formaPagamento : FormaPagamento.values()) {
            System.out.println(formaPagamento);
        }
    }

    public static FormaPagamento valueOf(int id) {
        for(FormaPagamento formaPagamento : FormaPagamento.values()) {
            if(formaPagamento.getId() == id) {
                return formaPagamento;
            }
        }

        throw new IllegalArgumentException("Forma de pagamento inválida!");
    }

    @Override
    public String toString() {
        return this.id + ": " + this.label;
    }
}
