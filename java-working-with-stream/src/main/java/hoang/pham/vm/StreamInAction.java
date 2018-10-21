package hoang.pham.vm;

import hoang.pham.vm.domains.Trader;
import hoang.pham.vm.domains.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamInAction {
    // 1. Find all transactions in the year 2011 and sort them by value (small to high).
    public static void findAllTransactionIn2001OrderByValue(List<Transaction> transactions){
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    // 2. What are all the unique cities where the traders work?
    public static void allUniqueCitiesTraderWork(List<Transaction> transactions){
        transactions.stream()
                //.map(trader -> trader.getCity())
                .map(transaction -> transaction.getTrader().getCity())
                //.distinct()
                //.collect(Collectors.toList())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
    // 3. Find all traders from Cambridge and sort them by name.
    public static void findAllTradersFromCity(List<Transaction> transactions, String city){
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(transaction -> transaction.getTrader())
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    // 4. Return a string of all traders’ names sorted alphabetically.
    public static void traderNameSorted(List<Transaction> transactions){
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .reduce("", (n1,n2)-> n1 + " " + n2 );
        System.out.println(names);

        names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(names);
    }
    // 5. Are any traders based in Milan?
    public static void isExistTraderInCity(List<Transaction> transactions, String city){
        boolean rs = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(city));
        System.out.println("Exist: " + rs);

    }
    // 6. Print the values of all transactions from the traders living in Cambridge.
    public static void findTransactionFromCity(List<Transaction> transactions, String city){
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                //.map(transaction -> transaction.getValue())
                //.collect(Collectors.toList())
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }
    // 7. What’s the highest value of all the transactions?
    public static void findHighestTransaction(List<Transaction> transactions){
        transactions.stream()
                .map(Transaction::getValue)
                .sorted((o1, o2) -> Integer.compare(o2,o1))
                .findFirst()
                .ifPresent(System.out::println);
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }
    // 8. Find the transaction with the smallest value.
    public static void findSmallestTransaction(List<Transaction> transactions){
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);

        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .ifPresent(System.out::println);
    }

}
