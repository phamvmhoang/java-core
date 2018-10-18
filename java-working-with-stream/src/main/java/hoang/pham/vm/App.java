package hoang.pham.vm;

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
        ReduceStream.countDish(menu);
    }
}
