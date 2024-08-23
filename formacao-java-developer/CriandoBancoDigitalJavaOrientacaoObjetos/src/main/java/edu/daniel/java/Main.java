package edu.daniel.java;

import edu.daniel.java.abstracts.Conta;
import edu.daniel.java.accounts.ContaCorrente;
import edu.daniel.java.accounts.ContaPoupanca;
import edu.daniel.java.models.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}