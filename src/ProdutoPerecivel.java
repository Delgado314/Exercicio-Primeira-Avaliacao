public class ProdutoPerecivel extends Product {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer)
            throws QuantidadeInvalidaException {
        super(nome, preco, quantidade);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcularValorTotal() {
        double total = getPreco() * getQuantidade();
        if (diasParaVencer <= 3) {
            total -= total * 0.20;
        }
        return total;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + String.format(" | vence em: %d dia(s)", diasParaVencer);
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }
}
