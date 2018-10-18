package hoang.pham.vm;

import java.util.List;

public class App {
    public static void main(String[] args) {

        /*List<Dish> menu = Dish.menu;
        FilterStream.filterWithPredicate(menu);
        FilterStream.filterUniqueElement();*/

        List<Dish> specialMenu = Dish.specialMenu;
        //SliceStream.sliceWithPredicate(specialMenu);
//        SliceStream.truncateStream(specialMenu);
//        SliceStream.skipELement(specialMenu);
        SliceStream.twoFisrtMeatDishes(specialMenu);
    }
}
