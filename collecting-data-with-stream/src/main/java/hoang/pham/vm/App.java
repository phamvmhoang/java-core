package hoang.pham.vm;

import hoang.pham.vm.domain.Dish;
import hoang.pham.vm.domain.Transaction;

import java.util.List;
import java.util.stream.LongStream;

public class App {

    public static void main(String[] args) {

        List<Transaction> transactions = Transaction.transactions;
        List<Dish> dishes = Dish.menu;

        //CollectorsSample.groupTransactionsByCurrency(transactions);
        //CollectorsSample.countDishInMenu(dishes);
        //CollectorsSample.findHighestCalorieDish(dishes);
        //CollectorsSample.totalCaloriesMenu(dishes);
        //CollectorsSample.aveCaloriesMenu(dishes);
        //CollectorsSample.menuStatistics(dishes);
        //CollectorsSample.collectNameOfDish(dishes);

        //GroupingSample.groupDishByType(dishes);
        //GroupingSample.classifyDishByType(dishes);
        //GroupingSample.classifyDishByTypeWithCondition(dishes);
        //GroupingSample.dishNamesByType(dishes);
        //GroupingSample.multiLevelGrouping(dishes);
        //GroupingSample.collectDataInSubgroups(dishes);
        //GroupingSample.getTotalCaloriesByType(dishes);
        //PartitioningSample.partitionedMenu(dishes);
        //PartitioningSample.vegetarianDishesByType(dishes);
        //PartitioningSample.mostCaloricPartitionedByVegetarian(dishes);
        //PartitioningSample.quiz62(dishes);
        //PartitioningSample.partitionPrimes(10);
        //System.out.println(CollectorInterface.partitionPrimesWithCustomCollector(10));
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            CollectorInterface.partitionPrimesWithCustomCollector(1000000);
            //PartitioningSample.partitionPrimes(1000000);
            long duration = (System.nanoTime() - start)/1000000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");
    }

}
