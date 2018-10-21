package hoang.pham.vm;

import hoang.pham.vm.domains.Trader;
import hoang.pham.vm.domains.Transaction;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;
        List<String> words = Arrays.asList("Pham", "Vu", "Minh", "Hoang");
        List<Integer> numbers = Arrays.asList(4,5,3,9);
        /*
        FilterStream.filterWithPredicate(menu);
        FilterStream.filterUniqueElement();*/

        List<Dish> specialMenu = Dish.specialMenu;
        //SliceStream.sliceWithPredicate(specialMenu);
        //SliceStream.truncateStream(specialMenu);
        //SliceStream.skipELement(specialMenu);
        //SliceStream.skipELement(specialMenu);
//        MapStream.converStringToInt(words);
//        MapStream.lengthOfDish(menu);
//        MapStream.uniquieChracters(words);
//        MapStream.quiz521();
        //MapStream.quiz522();
//        MapStream.quiz523();
//        FindAndMatchStream.hasVegetarian(menu);
        //FindAndMatchStream.allBelow1000(menu);
//        FindAndMatchStream.allAbove1000(menu);
//        FindAndMatchStream.findAnyDishWithVegaterian(menu);
        //FindAndMatchStream.findFirstNumber();
        //ReduceStream.sum(numbers);
        //ReduceStream.multiple(numbers);
        //ReduceStream.max(numbers);
        //ReduceStream.min(numbers);
        //ReduceStream.countDish(menu);

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Trader> traders = Arrays.asList(raoul,mario,alan,brian);
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //StreamInAction.findAllTransactionIn2001OrderByValue(transactions);
        //StreamInAction.allUniqueCitiesTraderWork(transactions);
        //StreamInAction.findAllTradersFromCity(transactions,"Cambridge");
        //StreamInAction.traderNameSorted(transactions);
        //StreamInAction.isExistTraderInCity(transactions,"Milan");
        //StreamInAction.findTransactionFromCity(transactions,"Cambridge");
        //StreamInAction.findHighestTransaction(transactions);
        StreamInAction.findSmallestTransaction(transactions);


    }
}
