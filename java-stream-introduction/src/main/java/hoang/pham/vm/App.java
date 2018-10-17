package hoang.pham.vm;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        // java 7
        //getLowCaloricDishes(menu);
        // java 8
        //getLowCaloricDishesStream(menu);
        //getLowCaloricDishesParallelStream(menu);
        //effectStream(menu);
        //getTopThreeCaloricDishName(menu);
        //externalIteration(menu);
       //internalIteration(menu);
        quiz41(menu);
    }

    private static void quiz41(List<Dish> menu) {
        List<String> highCaloricDishes = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return  dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        highCaloricDishes.stream().forEach(System.out::println);

    }

    private static void internalIteration(List<Dish> menu) {
        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    private static void externalIteration(List<Dish> menu) {
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        Iterator<Dish> iterator = menu.iterator();

        while (iterator.hasNext()){
            names.add(iterator.next().getName());
        }

        names.forEach(System.out::println);
    }

    static void getLowCaloricDishes(List<Dish> menu){

        // Filters the elements using an accumulator
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        // Sorts the dishes with an anonymous clas
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dishOne, Dish dishTwo) {
                return Integer.compare(dishOne.getCalories(), dishTwo.getCalories());
            }
        });

        // Processes the sorted list to select the names of dishes
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish caloricDish : lowCaloricDishes) {
            lowCaloricDishesName.add(caloricDish.getName());
        }

        lowCaloricDishesName.forEach(System.out::println);

    }

    static void getLowCaloricDishesStream(List<Dish> menu){

        List<String> lowCaloricDishesName = menu.stream()
                // Selects dishes that are below 400 calories
                .filter((Dish dish) -> dish.getCalories() < 400)
                // Sorts them by calories
                .sorted(Comparator.comparing(Dish::getCalories))
                // Extracts the names of these dishes
                .map((dish) -> dish.getName() )
                .collect(Collectors.toList());

        lowCaloricDishesName.forEach(System.out::println);

    }

    static void getLowCaloricDishesParallelStream(List<Dish> menu){

        List<String> lowCaloricDishesName = menu.parallelStream()
                // Selects dishes that are below 400 calories
                .filter((Dish dish) -> dish.getCalories() < 400)
                // Sorts them by calories
                .sorted(Comparator.comparing(Dish::getCalories))
                // Extracts the names of these dishes
                .map((dish) -> dish.getName() )
                .collect(Collectors.toList());

        lowCaloricDishesName.forEach(System.out::println);

    }

    static void effectStream(List<Dish> menu){

        Map<Dish.Type, List<Dish>> dishesByType = menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.printf(dishesByType.toString());

    }

    static  void getTopThreeCaloricDishName(List<Dish> menu){
        List<String> topThree =  menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                //.sorted(Comparator.comparing(Dish::getCalories))
                .limit(3)
                .collect(Collectors.toList());

        topThree.forEach(System.out::println);
    }

}
