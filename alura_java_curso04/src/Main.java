import model.Endereco;
import services.ConsultaCep;
import services.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o CEP para consulta: ");
        String cep = scanner.nextLine();

        try {
            ConsultaCep consultaCep = new ConsultaCep();
            Endereco endereco = consultaCep.buscaEndereco(cep);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(endereco);
            System.out.println(endereco);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}