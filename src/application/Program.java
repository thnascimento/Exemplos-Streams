package application;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Exemplos de uso de Streams

public class Program {

    @Test
    public void test () {

        // Transformar uma lista em Stream e mapeia os números para serem multiplicados por 10
        List<Integer> list = Arrays.asList(3, 4 ,5, 10, 7);
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // Criar uma stream de Strings
        Stream<String> st2 = Stream.of("Maria", "Alex" , "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        // Criar uma Stream de integers que pulam de 2 em 2
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        // Stream com a lógica da sequência de Fibonacci
        Stream<Long> st4 = Stream.iterate(new Long[]{ 0L, 1L }, x -> new Long[]{ x[1], x[0] + x[1] }).map((x -> x[0]));
        System.out.println(Arrays.toString(st4.limit(10).toArray()));
    }

    // Exemplo de pipeline
    @Test
    public void test1() {

        List<Integer> list = Arrays.asList(3, 4 ,5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // Soma todos os elementos da lista list
        int sum = list.stream().reduce(0, (x,y) -> x + y );
        System.out.println("Sum: " + sum);

        // Pipeline filtrando apenas os pares e depois mapeando para multiplicar todos os elementos por 10
        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .collect(Collectors.toList());
        System.out.println(newList);
    }
}
