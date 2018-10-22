package hoang.pham.vm.domains;

import hoang.pham.vm.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

    public static void calculateCalories(List<Dish> menu){
       int sum =  menu.stream()
                .map(Dish::getCalories)
                .reduce(0,Integer::sum);
        System.out.println(sum);
        sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);

        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed();

        OptionalInt optionalInt = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        optionalInt.ifPresent(value -> System.out.println(value));
    }

    public static void numericRangeExample(){
        //generate even numbers
        IntStream.rangeClosed(0,10)
                .filter(value -> value%2 == 0)
                .forEach(System.out::println);
        IntStream.range(1,10)
                //.filter(value -> value%2 == 0)
                .filter(value -> value%2==1)
                .forEach(System.out::println);
    }

    public static void findPythagoreanTriples(){
        IntStream.rangeClosed(1,10)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a,10)
                        .filter(b -> Math.sqrt(a*a + b*b)% 1 == 0)
                        .mapToObj(b -> new int[]{a,b, (int)Math.sqrt(a*a + b*b)})
                )
                .collect(Collectors.toList())
                .forEach((t -> {
                    System.out.println(t[0] + ", " + t[1] + ", " + t[2]);
                }));

        /*IntStream.rangeClosed(1,10)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100).mapToObj(b -> new double[][] {,b, Math.sqrt(a*a+b*b)}))
                .filter();*/
    }
}
