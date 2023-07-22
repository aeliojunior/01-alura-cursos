package br.com.lyrio.appcompras.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrinho {

    private List<Compra> compras = new ArrayList<>();
    private double totalCarrinho;
    private boolean compraFechada;

    public void novaCompra (Compra compra){
        compras.add(compra);
        totalCarrinho += compra.getValor();
    }

    public double getTotalCarrinho() {
        return totalCarrinho;
    }

    public boolean isCompraFechada() {
        return compraFechada;
    }

    public void fecharCarrinho(Cartao cartao){
        if ( totalCarrinho> cartao.getLimite()) {
            System.out.println("Compra não autorizada! Limite insuficiente!");
            System.out.println("Itens removidos do carrinho!");
            compras.clear();
            this.totalCarrinho = 0.0;
        } else {
            System.out.println("############# Compra finalizada #############\n");
            System.out.println("Titular do cartão: " + cartao.getTitular());
            System.out.println("Limite do cartão: " + cartao.getLimite());
            System.out.printf("Limite disponível no cartão: %.2f", cartao.getLimite()-totalCarrinho);
            System.out.println("\n\nItens comprados: ");
            compras.sort(Comparator.comparing(Compra::getDescricao));
            compras.forEach(compra -> System.out.println(compra)); //compras.forEach(System.out::println);
            System.out.printf("\nValor total da compra: %.2f", totalCarrinho);
            this.compraFechada = true;
        }
    }

}
