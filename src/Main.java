import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Stream<Dish> stream =menu.stream();
        List<String> threeHighCaloricDishNames = stream.filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(4).collect(toList());
        System.out.println(threeHighCaloricDishNames);




        int count = menu.stream().map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        long count1 = menu.stream().map(d -> 1).count();

        System.out.println("count:" + count + "count1:" + count1);

    }
}
