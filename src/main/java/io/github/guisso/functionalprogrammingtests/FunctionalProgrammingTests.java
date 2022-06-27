package io.github.guisso.functionalprogrammingtests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
public class FunctionalProgrammingTests {

    public static void main(String[] args) {

        Function<Double, Double> dobro = a -> a * 2;
        Double resposta = dobro.apply(3.0);
        System.out.println(">> " + resposta);

        // TODO Montar novas expressões para calcular triplo, quádruplo e quintuplo
        // TODO Montar novas expressões para calcular raiz quadrada, quadrado e metade
        TresParametros<Double, Double, Double, Double> equacaoReta
                = (m, x, b) -> m * x + b;
        Double y = equacaoReta.calcular(2.0, 1.0, 2.0);
        System.out.println(">> " + y);

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
        Supplier<IntStream> stream = () -> IntStream.of(idades);

//        IntStreamt().forEach(i -> System.out.println("> " + i));
//        stream.get fluxo = IntStream.of(idades);
//        stream.ge().forEach(i -> System.out.println("> " + i * 2));
        System.out.println("Total de idades");
        System.out.println("Total: " + stream.get()
                .count());

        System.out.println("Impressão de todas as idades");
        stream.get()
                .forEach(i -> System.out.println("> " + i));
        stream.get()
                .forEach(System.out::println);

        System.out.println("Impressão das 5 idades iniciais");
        stream.get()
                .limit(5)
                .forEach(i -> System.out.println("> " + i));

        System.out.println("Impressão de todas as idades ordenadas");
        stream.get()
                .sorted()
                .forEach(i -> System.out.println("= " + i));

        System.out.println("Impressão de todas as idades ordenadas descendente");
        stream.get()
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .forEach(i -> System.out.println("= " + i));

        System.out.println("Impressão de todas as idades distintas ordenadas");
        stream.get()
                .distinct()
                .sorted()
                .forEach(i -> System.out.println("* " + i));

        System.out.println("Impressão de todas as idades pares distintas ordenadas");
        stream.get()
                .filter(i -> i % 2 == 0)
                .distinct()
                .sorted()
                .forEach(i -> System.out.println("/ " + i));

        System.out.println("Menor idade");
        System.out.println("- " + stream.get()
                .min().getAsInt());

        System.out.println("Maior idade");
        System.out.println("- " + stream.get()
                .max().getAsInt());

        System.out.println("Total maioridades");
        System.out.println("+ " + stream.get()
                .filter(i -> i >= 18)
                .count());

        System.out.println("Total maioridades no próximo ano");
        System.out.println("+ " + stream.get()
                .filter(i -> i >= 17)
                .count());
        System.out.println("+ " + stream.get()
                .map(i -> i + 1)
                .filter(i -> i >= 18)
                .count());

        System.out.println("Soma das idades (sum)");
        System.out.println(": " + stream.get()
                .sum());
        System.out.println(": " + stream.get()
                .summaryStatistics());

        System.out.println("Soma das idades (reduce)");
        System.out.println(": " + stream.get()
                .reduce(0, (a, b) -> a + b));

        System.out.println("Idade média");
        System.out.println("= " + stream.get()
                .average().getAsDouble());

        System.out.println("Sorteio de 6 números aleatórios ordenados para a Mega Sena");
        // Java >= 10
        var rnd = new Random();
        //IntStream.rangeClosed(1, 6);
        IntStream.range(0, 6)
                .map(n -> rnd.nextInt(60) + 1)
                .sorted()
                .forEach(System.out::println);
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
                                    "Débora Wendel",
                                    LocalDate.of(1999, 1, 1)))
                            .add(new Docente(222222L,
                                    "Ana Zaira",
                                    LocalDate.of(1997, 2, 2)))
                            .add(new Docente(333333L,
                                    "Cecília Xerxes",
                                    LocalDate.of(1995, 3, 3)))
                            .add(new Docente(444444L,
                                    "Beatriz Yana",
                                    LocalDate.of(1993, 4, 4)))
                            .build();
                };

        System.out.println("Total de docentes");
        System.out.println("> " + docentes.get()
                .count());

        System.out.println("Todos os docentes");
        docentes.get()
                .forEach(System.out::println);
        docentes.get()
                .forEach(d -> System.out.println("- " + d));

        System.out.println("Nomes e idades dos docentes");
        docentes.get()
                .forEach(d -> System.out.println("+ "
                + d.getNome() + " / " + d.getIdade()));
        docentes.get()
                .forEach(d -> System.out.printf("%s [%d anos]\n",
                d.getNome(),
                d.getIdade()
        ));

        System.out.println("Idades e estatísticas destas");
        System.out.println("> "
                + docentes.get()
                        .mapToInt(d -> d.getIdade())
                        .peek(System.out::println)
                        .summaryStatistics());

        System.out.println("Lista de nomes");
        List<String> nomes = docentes.get()
                .map(d -> d.getNome())
                .collect(Collectors.toList());
        for (String n : nomes) {
            System.out.println("= " + n);
        }

        System.out.println("Lista de nomes em ordem inversa");
        List<String> nomesOrdemInversa = docentes.get()
                .map(d -> d.getNome())
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList());
        for (String n : nomesOrdemInversa) {
            System.out.println("< " + n);
        }

        System.out.println("Docentes por idade inversa");
        docentes.get()
                .sorted(Comparator.comparing(Docente::getIdade).reversed())
                .forEach(System.out::println);
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
        docentes.stream()
                .forEach(d -> System.out.println(") " + d));
    }

    private static void testarPredicados() {
        // -- Predicados --

        // Par
        IntPredicate par = v -> v % 2 == 0;

        // Maior que 18
        IntPredicate maior18 = v -> v >= 18;

        // Par e maior que 18
        IntPredicate parEMaior18 = par.and(maior18);

        // Maior que 18 e ímpar
        IntPredicate maior18EImpar = maior18.and(par.negate());

        // Processamento de arranjos de inteiros
        int[] idades = {46, 25, 22, 33, 15, 17, 13, 9, 9};

        System.out.println("Idades abaixo de 18");
        IntStream.of(idades)
                .filter(maior18.negate())
                .forEach(i -> System.out.println("* " + i));

        System.out.println("Idades acima de 18");
        IntStream.of(idades)
                .filter(maior18)
                .forEach(i -> System.out.println("* " + i));

        System.out.println("Idades pares e acima de 18");
        IntStream.of(idades)
                .filter(parEMaior18)
                .forEach(i -> System.out.println("* " + i));

        System.out.println("Idades ímpares e acima de 18");
        IntStream.of(idades)
                .filter(maior18EImpar)
                .forEach(i -> System.out.println("* " + i));
    }

}

@FunctionalInterface
interface TresParametros<U, V, W, X> {

    public X calcular(U u, V v, W w);
}
