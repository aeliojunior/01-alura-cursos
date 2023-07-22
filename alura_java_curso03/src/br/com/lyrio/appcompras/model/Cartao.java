package br.com.lyrio.appcompras.model;

public class Cartao {
    private String titular;
    private double limite;

    public Cartao(String titular, double limite) {
        this.titular = titular;
        this.limite = limite;
    }

    public String getTitular() {
        return titular;
    }

    public double getLimite() {
        return limite;
    }

}
