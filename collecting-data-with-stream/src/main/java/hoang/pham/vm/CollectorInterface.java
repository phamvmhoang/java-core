package hoang.pham.vm;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CollectorInterface {

    public static boolean isPrimeV9(List<Integer> primes, int cadidate){
        // limit test
        int candidateRoot = (int) Math.sqrt( (double) cadidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot) // java 9
                .noneMatch(num -> cadidate % num == 0);

    }


    public static boolean isPrimeV8(List<Integer> primes, int cadidate){
        // limit test
        int candidatRoot = (int) Math.sqrt( (double) cadidate);
        return takeWhile(primes, i -> i <= candidatRoot)
                .stream()
                .noneMatch(num -> cadidate % num == 0);

    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> predicate ){
        int i = 0;
        for (A a : list) {
            if (!predicate.test(a)){
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }


    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(new PrimeNumbersCollector());
    }


}
