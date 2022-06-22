package io.github.guisso.functionalprogrammingtests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
public class FunctionalProgrammingTests {

    public static void main(String[] args) {

        System.out.println("-- Testando IntStream --");
        testarIntStream();

        System.out.println("-- Testando streams de objetos --");
        processarDocentes();

        System.out.println("-- Testando geração de streams a partir de listas");
        processarListas();

        System.out.println("-- Testando predicados --");
        testarPredicados();

    }

    private static void testarIntStream() {
        // Processamento de arranjos de inteiros
        int[] idades = {15, 17, 46, 22, 22, 13, 33, 9, 9};

        // Operações consecutivas no mesmo fluxo
        
        System.out.println("Total de idades");

        System.out.println("Impressão de todas as idades");

        System.out.println("Impressão das 5 idades iniciais");

        System.out.println("Impressão de todas as idades ordenadas");

        System.out.println("Impressão de todas as idades ordenadas descendente");

        System.out.println("Impressão de todas as idades distintas ordenadas");

        System.out.println("Impressão de todas as idades pares distintas ordenadas");

        System.out.println("Menor idade");

        System.out.println("Maior idade");

        System.out.println("Total maioridades");

        System.out.println("Total maioridades no próximo ano");

        System.out.println("Soma das idades (sum)");

        System.out.println("Soma das idades (reduce)");

        System.out.println("Idade média");

        System.out.println("Sorteio de 6 números aleatórios ordenados para a Mega Sena");
        // Java >= 10
        var rnd = new Random();

    }

    private static void processarDocentes() {
        System.out.println("-- Processando Docentes --");

        // Supplier => get()
        Supplier<Stream<Docente>> docentes
                = () -> {
                    // Geração do construtor
                    Stream.Builder<Docente> builder
                    = Stream.builder();

                    // Construção
                    return builder
                            .add(new Docente(111111L,
                                    "Ana Zaira",
                                    LocalDate.of(1999, 1, 1)))
                            .add(new Docente(222222L, "Beatriz Yana", LocalDate.of(1997, 2, 2)))
                            .add(new Docente(333333L,
                                    "Cecília Xerxes",
                                    LocalDate.of(1995, 3, 3)))
                            .add(new Docente(444444L,
                                    "Débora Wendel",
                                    LocalDate.of(1993, 4, 4)))
                            .build();
                };

        System.out.println("Total de docentes");

        System.out.println("Todos os docentes");

        System.out.println("Nomes e idades dos docentes");

    }

    public static void processarListas() {
        List<Docente> docentes
                = new ArrayList<>();

        docentes.add(new Docente(111111L,
                "Ana Zaira",
                LocalDate.of(1999, 1, 1)));
        docentes.add(new Docente(222222L,
                "Beatriz Yana",
                LocalDate.of(1997, 2, 2)));
        docentes.add(new Docente(333333L,
                "Cecília Wendel",
                LocalDate.of(1995, 3, 3)));

        System.out.println("Impressão dos docentes");
    }

    private static void testarPredicados() {
        // -- Predicados --
        
        // Par
        
        // Maior que 18

        // Par e maior que 18
        
        // Maior que 18 e ímpar

        // Processamento de arranjos de inteiros
        int[] idades = {46, 25, 22, 33, 15, 17, 13, 9, 9};

        System.out.println("Idades abaixo de 18");

        System.out.println("Idades acima de 18");

        System.out.println("Idades pares e acima de 18");

        System.out.println("Idades ímpares e acima de 18");
    }

}
