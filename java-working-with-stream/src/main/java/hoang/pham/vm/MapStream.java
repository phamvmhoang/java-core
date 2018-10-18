package hoang.pham.vm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {

    public static void converStringToInt(List<String> words){
        words.stream()
//                .map(word->word.length())
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void lengthOfDish(List<Dish> menu){
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                //.map(dish -> dish.getName().length())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void uniquieChracters(List<String> words){
        words.stream()
                .map(word -> word.split(""))
                // Flattens each generated stream into a single stream
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void quiz521(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                .map(number -> number * number )
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void quiz522(){

        List<Integer> numArrOne = Arrays.asList(1,2,3);
        List<Integer> numArrTwo = Arrays.asList(3,4);

        numArrOne.stream()
                .flatMap(i -> numArrTwo.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList())
                //.forEach(arr-> Arrays.stream(arr).forEach(System.out::println));
                .forEach(arr -> {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                    }
                    System.out.println();
                });

    }

    public static void quiz523(){
        List<Integer> numArrOne = Arrays.asList(1,2,3);
        List<Integer> numArrTwo = Arrays.asList(3,4);

        numArrOne.stream()
                .flatMap(i -> numArrTwo.stream()
                        //.filter(j->(i+j)%3 == 0)
                        .map(j -> new int[]{i,j}))
                .filter(arr -> {
                    if(((arr[0] + arr[1])%3) ==0){
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList())
                .forEach(arr -> {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                    }
                    System.out.println();
                });

    }

}
