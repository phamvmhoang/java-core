package hoang.pham.vm;

import hoang.pham.vm.domain.CaloricLevel;
import hoang.pham.vm.domain.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingSample {

    public static void groupDishByType(List<Dish> menu){
        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishByType);
    }

    public static void classifyDishByType(List<Dish> menu){
        Map<CaloricLevel, List<Dish>> dishByType = menu.stream()
                .collect(Collectors.groupingBy((Dish dish) -> {
                    if (dish.getCalories() <= 400){
                        return CaloricLevel.DIET;
                    } else if ((dish.getCalories() > 400) && (dish.getCalories() < 700)){
                        return CaloricLevel.NORMAL;
                    } else
                        return CaloricLevel.FAT;
                }));

        System.out.println(dishByType);
    }

    public static  void classifyDishByTypeWithCondition(List<Dish> menu){
        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishByType);

        dishByType = menu.stream()
                .collect(Collectors.groupingBy (
                        Dish::getType,
                        Collectors.filtering((Dish dish) -> dish.getCalories() > 500,Collectors.toList())));
        System.out.println(dishByType);

    }

    public static void dishNamesByType(List<Dish> menu){
        Map<Dish.Type, List<String>> dishByType = menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.mapping(Dish::getName, Collectors.toList())
                        ));

        System.out.println(dishByType);

        Map<Dish.Type, Set<String>> dishByTypeSet = menu.stream()
                .collect(
                        Collectors.groupingBy(
                                Dish::getType,
                                Collectors.flatMapping(
                                        (Dish dish) -> Dish.dishTags.get(dish.getName()).stream(),
                                        Collectors.toSet()
                                )
                ));

        System.out.println(dishByTypeSet);
    }

    public static void multiLevelGrouping(List<Dish> menu){
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(
                        Collectors.groupingBy(
                            Dish::getType,
                            Collectors.groupingBy((Dish dish) -> {
                                if (dish.getCalories() <= 400){
                                    return CaloricLevel.DIET;
                                } else if ((dish.getCalories() > 400) && (dish.getCalories() < 700)){
                                    return CaloricLevel.NORMAL;
                                } else
                                    return CaloricLevel.FAT;
                            })
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);
    }

    public static void  collectDataInSubgroups(List<Dish> menu){
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(
                    Collectors.groupingBy(
                        Dish::getType,
                        Collectors.counting()
                    )
                );
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                ));

        System.out.println(mostCaloricByType);

        Map<Dish.Type, Dish> mostCaloricByTypeDish = menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )
                ));

        System.out.println(mostCaloricByTypeDish);
    }

    public static void getTotalCaloriesByType(List<Dish> menu){
       Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
               .collect(
                   Collectors.groupingBy(
                           Dish::getType,
                           Collectors.summingInt(Dish::getCalories)
                   )
               );
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.mapping( (Dish dish) -> {
                            if (dish.getCalories() <= 400){
                                return CaloricLevel.DIET;
                            } else if ((dish.getCalories() > 400) && (dish.getCalories() < 700)){
                                return CaloricLevel.NORMAL;
                            } else
                                return CaloricLevel.FAT;
                        //}, Collectors.toSet())
                        //}, Collectors.toSet())
                        }, Collectors.toCollection(HashSet::new))
                ));
        System.out.println(caloricLevelsByType);
    }
}
