package hoang.pham.vm;

import hoang.pham.vm.domain.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class PartitioningSample {

    public static void partitionedMenu(List<Dish> menu){
        Map<Boolean,List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
    }

    public static void vegetarianDishesByType(List<Dish> menu){
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian,
                        groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);
    }

    public static  void mostCaloricPartitionedByVegetarian(List<Dish> menu){
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )
                ));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    public static void quiz62(List<Dish> menu){
        Map<Boolean, Map<Boolean, List<Dish>>> dishHightCalories = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian,
                        partitioningBy((Dish dish) -> dish.getCalories() > 500 )));

        System.out.println(dishHightCalories);

        /*Map<Boolean, Map<Dish.Type, List<Dish>>> dishByVeByType = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian,
                        partitioningBy(Dish::getType)));
        */
        Map<Boolean, Long> countDishByVe = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian,
                        counting()
                ));
        System.out.println(countDishByVe);
    }

    /**
     * chekc if input value is prime number or not
     * @param input
     * @return
     */
    public static boolean isPrime(int input){
        return LongStream.range(2,input)
                .limit((long) Math.sqrt((double) input))
                .noneMatch(value -> input % value == 0);
    }

    public static void partitionPrimes(int n){
        Map<Boolean, List<Integer>> partitionPrimes = IntStream.rangeClosed(2,n)
                .boxed()
                .collect(partitioningBy((value -> isPrime(value))));
        System.out.println(partitionPrimes);
    }

}
