package hoang.pham.vm;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceStream {

    public static void sum(List<Integer> numbers ){
        int sum = numbers.stream()
                //.reduce(0,(a,b) -> a +b)
                .reduce(0,Integer::sum)
                .intValue();
        System.out.println("Sum: " + sum);
    }

    public static void multiple(List<Integer> numbers ){
        int rs = numbers.stream()
                .reduce(1,(a,b) -> a * b)
                .intValue();
        System.out.println("Multiple: " + rs);
    }

    public static void max(List<Integer> numbers ){
        Optional<Integer> rs = numbers.stream()
                .reduce(Integer::max);
        rs.ifPresent((num) -> System.out.println("Max: " + num));
    }

    public static void min(List<Integer> numbers ){
        Optional<Integer> rs = numbers.stream()
                .reduce(Integer::min);
        rs.ifPresent((num) -> System.out.println("Min: " + num));
    }

    public static void countDish(List<Dish> menu ){
        Integer rs = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println("Total Dishes: : " + rs);
    }
}
