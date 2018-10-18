package hoang.pham.vm;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindAndMatchStream {

    public static void hasVegetarian(List<Dish> menu){
        boolean rs = menu.stream()
//                .anyMatch(dish -> dish.isVegetarian());
                .anyMatch(Dish::isVegetarian);
        System.out.println("Vegetarian: " + rs);
    }

    public static void allBelow1000(List<Dish> menu){
       boolean rs = menu.stream()
               .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("All below 1000: " + rs);
    }

    public static void allAbove1000(List<Dish> menu) {
        boolean rs = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("All above 1000: " + rs);
    }

    public static void findAnyDishWithVegaterian(List<Dish> menu) {
        menu.stream()
                //.filter(dish -> dish.isVegetarian())
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent((dish -> System.out.println("Has dish with vegetarian")));
    }

    public static void findFirstNumber(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                .map(number -> (number * number))
                .filter(num -> num % 3 ==0)
                .findFirst()
                .ifPresent(data-> System.out.println(data.toString()));
    }
}

