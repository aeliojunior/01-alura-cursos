package br.com.lyrio.appcompras.main;

import br.com.lyrio.appcompras.model.Carrinho;
import br.com.lyrio.appcompras.model.Cartao;
import br.com.lyrio.appcompras.model.Compra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n>>>>>>>>>> Inicializando aplicação! <<<<<<<<<<");

        Scanner scanner = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();

        String menu1 = """
                Informe a opção desejada:
                1 - Para realizar uma compra                
                2 - Sair
                """;
        System.out.println("\n" + menu1);
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.println("\nInforme o titular do cartão: ");
            String titular = scanner.next();
            System.out.println("Informe o limite do cartão: ");
            double limite = scanner.nextDouble();
            Cartao cartao = new Cartao(titular, limite);

            String menu2 = """
                    Digite:
                    1 - Comprar um produto
                    2 - Fechar compra
                    3 - Sair
                    """;
            opcao = 0;

            while (opcao != 3) {
                System.out.println("\n" + menu2);
                opcao = scanner.nextInt();
                if (opcao == 1) {
                    System.out.println("Informe a descrição do produto: ");
                    String descProduto = scanner.next();
                    System.out.println("Informe o valor do produto: ");
                    double valorProduto = scanner.nextDouble();
                    Compra compra = new Compra(descProduto, valorProduto);
                    carrinho.novaCompra(compra);
                } else if (opcao == 2) {

                    System.out.println("Fechando carrinho...");
                    carrinho.fecharCarrinho(cartao);

                    if (carrinho.isCompraFechada()) break;
                } else if (opcao != 3) {
                    System.out.println("Opção inválida");
                } else if (opcao == 3 && carrinho.getTotalCarrinho() > 0 && !carrinho.isCompraFechada()) {
                    System.out.println("Compra não finalizada! \nFinalizar antes de sair (S/N)?");
                    char confirmaSaida = scanner.next().charAt(0);
                    if (confirmaSaida == 'S') {

                        carrinho.fecharCarrinho(cartao);
                    }
                } else if (opcao == 3) {
                    System.out.println("\n\n>>>>>>>>>> Finalizando aplicação! <<<<<<<<<<");
                }
            }
        }
        System.out.println("\n\nAplicação finalizada com sucesso!");

    }
}