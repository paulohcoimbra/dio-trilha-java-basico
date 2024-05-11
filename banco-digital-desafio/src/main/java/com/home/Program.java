package com.home;

import com.home.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    static final Banco banco = new Banco();
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        ContaBancariaInterface conta;

        System.out.println("********** BANCO DIGITAL **********");
        System.out.println();
        System.out.println("Para que iniciemos seu atendimento");

        System.out.print("Informe sua agencia: ");
        Integer agencia = scan.nextInt();

        System.out.print("Informe sua conta: ");
        Integer numero = scan.nextInt();


        try {
            conta = banco.findByAgenciaNumero(agencia, numero);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Seja Bem-Vindo " + conta.getNomeCliente());
        System.out.println();
        do {
            System.out.println("O que deseja?");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Transferir");
            System.out.println("4. Saldo");
            System.out.println("0. Sair");
            System.out.print("Informe a opcao desejada:");
            String userInput = scan.next();

            switch (userInput){
                case "1":
                    sacar(conta);
                    break;
                case "2":
                    depositar(conta);
                    break;
                case "3":
                    tranferir(conta);
                    break;
                case "4":
                    conta.imprimirExtrato();
                    break;
                default:
                    System.out.println("Até mais...");
                    return;
            }
        } while(true);
    }

    private static void tranferir(ContaBancariaInterface conta) {
        ContaBancariaInterface contaDestino;

        System.out.println("Informe os dados da conta destino");
        System.out.print("Agencia: ");
        Integer agencia = scan.nextInt();

        System.out.print("Conta: ");
        Integer numero = scan.nextInt();

        try {
            contaDestino = banco.findByAgenciaNumero(agencia, numero);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Informe o valor a ser transferido: ");
        Double valor = scan.nextDouble();

        try {
            conta.transferir(valor, contaDestino);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void depositar(ContaBancariaInterface conta) {
        System.out.print("Informe o valor a ser depositado: ");
        Double valor = scan.nextDouble();

        conta.depositar(valor);
        System.out.println("Deposito efetuado com sucesso!");
    }

    private static void sacar(ContaBancariaInterface conta) {
        System.out.print("Informe o valor a ser sacado: ");
        Double valor = scan.nextDouble();

        try {
            conta.sacar(valor);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Saque efetuado com sucesso!");
    }

    static void init() {
        gerarContas();
    }

    static void gerarContas() {
        Cliente jose = new Cliente("José");
        ContaCorrente c1 = new ContaCorrente(jose);

        Cliente andre = new Cliente("André");
        ContaCorrente c2 = new ContaCorrente(andre);

        Cliente batista = new Cliente("Batista");
        ContaCorrente c3 = new ContaCorrente(batista);

        Cliente carlos = new Cliente("Carlos");
        ContaCorrente c4 = new ContaCorrente(carlos);

        Cliente henrique = new Cliente("Henrique");
        ContaCorrente c5 = new ContaCorrente(henrique);

        banco.setContas(Arrays.asList(c1, c2, c3, c4, c5));
    }
}
