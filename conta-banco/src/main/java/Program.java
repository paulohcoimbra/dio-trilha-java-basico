import java.util.Locale;
import java.util.Scanner;
import model.Conta;

public class Program {
    static final Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void main(String[] args) {
        System.out.println("***** CONTA TERMINAL *****");
        System.out.println("--------------------------");
        System.out.println("------- BEM-VINDO --------\n\n");

        System.out.println("Sistema: Informe o numero da conta");
        System.out.print("Usuario: ");
        int numero = sc.nextInt();

        System.out.println("Sistema: Informe a agência da conta");
        System.out.print("Usuario: ");
        String agencia = sc.next();

        System.out.println("Sistema: Informe o nome");
        System.out.print("Usuario: ");
        String nome = sc.next();

        System.out.println("Sistema: Informe o saldo da conta");
        System.out.print("Usuario: ");
        double saldo = sc.nextDouble();

        Conta conta = new Conta(numero, agencia, nome, saldo);
        System.out.println(conta);
    }
}
