package edu.daniel.java.basico;

import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.println("Informe o número da agência: ");
        String agencia = scanner.next();

        System.out.println("Informe o nome do cliente: ");
        String nomeCliente = scanner.next();

        System.out.println("Informe o saldo da conta: ");
        double saldo = scanner.nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " +
                agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque");
    }
}