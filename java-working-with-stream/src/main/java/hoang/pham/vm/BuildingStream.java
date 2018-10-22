package hoang.pham.vm;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStream {

    public static void streamsFromValues(){
        Stream.of("Pham","Vu","Minh","Hoang")
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    //java 9
    public static void streamFromNullable(){
        Stream<String> values = Stream.of("config","home","user")
                .flatMap(s -> Stream.ofNullable(System.getProperty(s)));
        values.forEach(System.out::println);
    }

    public static void streamFromArray(){
        int[] numbers = {1,3,5,7,9};
        Stream<Integer> integerStream = Arrays.stream(numbers).boxed();
    }

    public static void quiz54Iterate(){
       Stream.iterate(new int[]{0,1}, (int[] arr) -> new int[] {arr[1], arr[0] + arr[1]})
               .mapToInt(value -> value[0])
               .limit(20)
               //.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
               .forEach(System.out::println);
       /*Stream.generate(Math::random)
               .limit(5)
               .forEach(System.out::println);*/



    }

    public static void quiz54Generate(){
        IntSupplier intSupplier = new IntSupplier() {

            private int prev = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrev = this.prev;
                int nextVal = prev + current;
                this.prev = this.current;
                this.current = nextVal;
                return oldPrev;
            }
        };

        IntStream.generate(intSupplier)
                .limit(10)
                .forEach(System.out::println);



    }

}
