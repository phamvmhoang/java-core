package hoang.pham.vm;

import java.util.List;
import java.util.stream.Collectors;

public class SliceStream {

    public static void sliceWithPredicate(List<Dish> menu){
        // java 9
        System.out.println("-------Using filter--------");
        menu.stream()
            .filter(dish -> dish.getCalories() < 320)
            .collect(Collectors.toList())
            .forEach(System.out::println);
        System.out.println("--------Using takewhile--------");

        menu.stream()
            .takeWhile(dish ->dish.getCalories() <320)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        System.out.println("--------Using dropWhile--------");
        menu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void truncateStream(List<Dish> menu){
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void skipELement(List<Dish> menu) {
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void twoFisrtMeatDishes(List<Dish> menu) {
        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }
}

