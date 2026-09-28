public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        try {
            estoque.adicionarProduto(new ProdutoComum("Teclado Mecanico", 250.00, 10));
            estoque.adicionarProduto(new ProdutoComum("Mouse Gamer", 150.00, 20));
            estoque.adicionarProduto(new ProdutoPerecivel("Leite Integral", 5.50, 30, 10));
            estoque.adicionarProduto(new ProdutoPerecivel("Iogurte Natural", 4.00, 15, 2));

            System.out.println("=== Produtos cadastrados ===");
            for (int i = 0; i < estoque.getProdutos().size(); i++) {
                System.out.println(estoque.getProduto(i).getDescricao());
            }

            System.out.println();
            System.out.println("=== Cadastro invalido ===");
            try {
                estoque.adicionarProduto(new ProdutoComum("Produto Negativo", 10.00, -5));
            } catch (QuantidadeInvalidaException e) {
                System.out.println("QuantidadeInvalidaException capturada: " + e.getMessage());
            }

            System.out.println();
            System.out.println("=== Venda valida ===");
            estoque.venderProduto(0, 3);
            System.out.println("Venda de 3 unidade(s) de "
                    + estoque.getProdutos().get(0).getNome() + " realizada com sucesso.");
            System.out.println("Descricao atualizada: "
                    + estoque.getProdutos().get(0).getDescricao());

            System.out.println();
            System.out.println("=== Venda acima do estoque ===");
            try {
                estoque.venderProduto(0, 1000);
            } catch (ProdutoIndisponivelException e) {
                System.out.println("ProdutoIndisponivelException capturada: " + e.getMessage());
            }

            System.out.println();
            System.out.printf("Valor total do estoque: R$ %.2f%n",
                    estoque.calcularValorTotalEstoque());
        } catch (QuantidadeInvalidaException e) {
            System.out.println("Erro de quantidade: " + e.getMessage());
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Erro de venda: " + e.getMessage());
        } catch (EstoqueException e) {
            System.out.println("Erro generico de estoque: " + e.getMessage());
        }
    }
}
