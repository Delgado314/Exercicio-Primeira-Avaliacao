public abstract class Product implements Vendavel {
    private String nome;
    private double preco;
    private int quantidade;

    public Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
        if (preco < 0 || quantidade < 0) {
            throw new QuantidadeInvalidaException(
                    "Preco e quantidade nao podem ser negativos: " + nome);
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract double calcularValorTotal();

    public String getDescricao() {
        return String.format("%s | preco: R$ %.2f | quantidade: %d", nome, preco, quantidade);
    }

    @Override
    public void vender(int quantidadeDesejada) throws ProdutoIndisponivelException {
        if (quantidadeDesejada > quantidade) {
            throw new ProdutoIndisponivelException(
                    "Estoque insuficiente de " + nome + ": solicitado "
                            + quantidadeDesejada + ", disponivel " + quantidade);
        }
        quantidade -= quantidadeDesejada;
    }

    void aplicarDesconto(double percentual) {
        double desconto = percentual;
        if (desconto < 0) {
            desconto = 0;
        }
        if (desconto > 100) {
            desconto = 100;
        }
        preco -= preco * (desconto / 100.0);
    }

    void aplicarDesconto(double percentual, double descontoMaximo) {
        if (percentual > descontoMaximo) {
            percentual = descontoMaximo;
        }
        aplicarDesconto(percentual);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
