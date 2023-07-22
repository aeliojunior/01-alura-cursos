import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String div = "\n*************************************\n";

        double saldo = 2500.0;

        String dadosIniciais = """
                *************************************
                Dados iniciais do cliente:
                
                Nome:           Aélio Júnior
                Tipo de conta:  Corrente
                Saldo inicial:  R$ 2.500,00
                *************************************                                            
                """;

        String operacoes = """                                
                \n>> Operações:
                
                1 - Consultar saldo
                2 - Depositar
                3 - Sacar
                4 - Sair
                
                Digite a opção desejada:               
                """;

        System.out.print(dadosIniciais);

        int opcao = 0;
        double valorOperacao = 0.0;

        while (opcao != 4) {

            System.out.print(div);
            System.out.print(operacoes);
            opcao = scanner.nextInt();

            if (opcao==1) {
                System.out.printf("\n### O saldo atual é: R$ %.2f ###", saldo);
            } else if (opcao==2) {
                System.out.println("Informe o valor que deseja depositar:");
                valorOperacao = scanner.nextDouble();
                if (valorOperacao>0) {
                    saldo += valorOperacao;
                    System.out.println("\nDepositando...\n");
                    Thread.sleep(500);
                    System.out.printf("### Saldo atualizado: R$ %.2f ###", saldo);
                } else {
                    System.out.println("Valor inválido para depósito");
                }
            } else if (opcao==3) {
                System.out.println("Informe o valor que deseja sacar:");
                valorOperacao = scanner.nextDouble();
                if (valorOperacao>0) {
                    if (valorOperacao<=saldo) {
                        saldo -= valorOperacao;
                        System.out.println("\nSacando...\n");
                        Thread.sleep(500);
                        System.out.printf("### Saldo atualizado: R$ %.2f ###", saldo);
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                } else {
                    System.out.println("Valor inválido para saque!");
                }
            } else if (opcao==4) {
                System.out.println("\nFinalizando...\n");
                Thread.sleep(500);
            } else {
                System.out.println("Opção inválida!");
            }
        }

    }
}