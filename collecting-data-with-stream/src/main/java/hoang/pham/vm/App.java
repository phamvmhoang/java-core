package hoang.pham.vm;

import hoang.pham.vm.domain.Dish;
import hoang.pham.vm.domain.Transaction;

import java.util.List;

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
        GroupingSample.getTotalCaloriesByType(dishes);

    }

}
