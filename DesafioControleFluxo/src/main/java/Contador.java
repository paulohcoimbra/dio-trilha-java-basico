import exceptions.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {

    static final Scanner terminal = new Scanner(System.in);

    public static void main(String[] args) {

        //Obtendo dados de entrada do usuario
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();

        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);
        }catch (ParametrosInvalidosException ex) {
            System.out.print(ex.getMessage());
        }

    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {

        // Regra de negócio: o parametro um não pode ser maior que o segundo
        if(parametroUm > parametroDois)
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");

        int contagem = parametroDois - parametroUm;

        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
