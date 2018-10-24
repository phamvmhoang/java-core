package hoang.pham.vm;

import hoang.pham.vm.domain.Currency;
import hoang.pham.vm.domain.Dish;
import hoang.pham.vm.domain.Transaction;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsSample {

    public static void groupTransactionsByCurrency(List<Transaction> transactions){
        Map<Currency, List<Transaction>> listMap =  transactions.stream()
                .collect(groupingBy(Transaction::getCurrency));

        listMap.forEach((currency, transaction) -> System.out.println(transaction));

    }

    public static void countDishInMenu(List<Dish> dishes){
        long total = dishes.stream()
                .collect(counting());
        System.out.println("Total: " + total);

        // compact verion
        total = dishes.stream().count();
        System.out.println("Total: " + total);
    }

    public static void findHighestCalorieDish(List<Dish> menu){

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        menu.stream()
                .collect(maxBy(dishCaloriesComparator))
                .ifPresent(System.out::println);

        menu.stream()
                .collect(minBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);

        menu.stream()
                .collect(reducing((dish1, dish2) -> Integer.compare(dish1.getCalories(), dish2.getCalories()) > 0? dish1: dish2))
                .ifPresent(System.out::println);


    }

    public static void totalCaloriesMenu(List<Dish> menu){
        int total =  menu.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println("Total number of calories in your menu: " + total);

        total = menu.stream()
                .collect(reducing(0,Dish::getCalories,(i, j) -> i+j));

        total = menu.stream()
                .collect(reducing(0,Dish::getCalories, Integer::sum));

        System.out.println("Total number of calories in your menu: " + total);


    }

    public static void aveCaloriesMenu(List<Dish> menu){
        double ave =  menu.stream()
                .collect(averagingInt(Dish::getCalories));
        System.out.println("Average number of calories in your menu: " + ave);
    }

    public static void menuStatistics(List<Dish> menu){
        IntSummaryStatistics statistics =  menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(statistics);
    }


    public static void collectNameOfDish(List<Dish> menu){
        String names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println("Names: " + names);
        //names = menu.stream().collect(joining());
        names = menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println("Names: " + names);
    }

    public static void  quiz61(){

    }


}
