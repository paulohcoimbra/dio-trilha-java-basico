package com.home;

import com.home.model.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    static final Scanner scan = new Scanner(System.in);
    static final Bootcamp bootcamp = init();
    static final Dev currentDev = new Dev();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Bootcamp");
        System.out.println(bootcamp.getNome());
        System.out.println("*********************************\n");

        System.out.println("Vamos dar inicio a sua matricula");
        System.out.print("Qual seu nome? ");
        String nome = scan.next();

        currentDev.setNome(nome);
        currentDev.inscreverBootcamp(bootcamp);

        System.out.println("\nVamos lá " + currentDev.getNome());
        System.out.println("Sua incrição foi realizada com sucesso");

        String userInput;
        do {
            if(currentDev.getConteudosInscritos().size() == 0) {
                System.out.println("Parabéns voce concluiu o bootcamp!");
                return;
            }

            System.out.println("Atualmente voce esta inscrito em " + currentDev.getConteudosInscritos().size() + " conteúdo(s)");
            System.out.println("e concluiu " + currentDev.getConteudosConcluidos().size() + " conteúdo(s)");

            System.out.print("Gostaria de realizar um conteúdo agora? (s/n)");
            userInput = scan.next();

            if(userInput.toLowerCase().equals("n")) {
                System.out.println("Até mais...");
                return;
            }

            Optional<Conteudo> conteudo = currentDev.progredir();

            System.out.println(conteudo.get().getTitulo() + " concluído com sucesso!");
            System.out.println("XP total: " + currentDev.calcularTotalXp());
        } while(true);
    }

    static Bootcamp init() {
        Curso introducaoJava = new Curso();
        introducaoJava.setTitulo("Introducao a plataforma java");
        introducaoJava.setDescricao("descrição curso java");
        introducaoJava.setCargaHoraria(1);

        Curso ambienteDevJava = new Curso();
        ambienteDevJava.setTitulo("Ambiente de desenvolvimento java");
        ambienteDevJava.setDescricao("descrição...");
        ambienteDevJava.setCargaHoraria(1);

        Curso aprendendoSintaxJava = new Curso();
        aprendendoSintaxJava.setTitulo("Aprendendo a sintax java");
        aprendendoSintaxJava.setDescricao("descrição...");
        aprendendoSintaxJava.setCargaHoraria(5);
        
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("A Importância da Lógica no Dia a Dia de Profissionais de Tecnologia");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Santander 2024 - Backend com Java");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(introducaoJava);
        bootcamp.getConteudos().add(ambienteDevJava);
        bootcamp.getConteudos().add(aprendendoSintaxJava);
        bootcamp.getConteudos().add(mentoria);

        return bootcamp;
    }
}
