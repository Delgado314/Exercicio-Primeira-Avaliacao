import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Product> produtos = new ArrayList<>();

    public void adicionarProduto(Product p) {
        produtos.add(p);
    }

    public void venderProduto(int indice, int quantidade) throws ProdutoIndisponivelException {
        produtos.get(indice).vender(quantidade);
    }

    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Product p : produtos) {
            total += p.calcularValorTotal();
        }
        return total;
    }

    public Product getProduto(int indice) throws EstoqueException {
        if (indice < 0 || indice >= produtos.size()) {
            throw new EstoqueException("Indice de produto invalido: " + indice);
        }
        return produtos.get(indice);
    }

    public List<Product> getProdutos() {
        return produtos;
    }
}
