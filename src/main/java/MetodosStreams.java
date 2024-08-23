import java.util.stream.Stream;

public class MetodosStreams {
    public static void main(String[] args) {
        Stream<Number> notas = Stream.of(10, 8.75, 7, 9, 8.5);
        notas.forEach(System.out::println);

        System.out.println("*********** </hr> ***********");

        Number[] maisNotas = {9, 8, 7.5, 8.75, 10};
        Stream.of(maisNotas).forEach(System.out::println);

        System.out.println("*********** </hr> ***********");

        Double[] outrasNotas = {9.0, 9.0, 10.0, 8.5, 10.0, 4.0};
        Stream.of(outrasNotas)
                .filter(nota -> nota <= 5)
                .map(nota -> nota + 2)
                .forEach(System.out::println);

        System.out.println("*********** </hr> ***********");

        Double[] notasComReduce = {9.0, 9.0, 10.0, 8.5, 10.0, 4.0};
        Boolean aprovado = Stream.of(notasComReduce)
                .reduce((acumulador, nota) -> acumulador + nota)
                .map(somaDasNotas -> somaDasNotas / 5)
                .filter(nota -> nota > 7)
                .isPresent();

        System.out.println("Voce foi aprovado: " + (aprovado ? "sim" : "não"));

        System.out.println("*********** </hr> ***********");

        Double[] notasComMatch = {9.0, 9.0, 10.0, 8.5, 10.0, 4.0};
        // allMatch
        // noneMatch
        Boolean aprovadoComMatch = Stream.of(notasComMatch).anyMatch(nota -> nota > 7);
        System.out.println(aprovadoComMatch);
    }
}
