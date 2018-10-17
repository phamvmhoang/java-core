package hoang.pham.vm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStream {

    public static void filterWithPredicate(List<Dish> menu){
        menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void filterUniqueElement(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(number -> number%2 == 0)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
