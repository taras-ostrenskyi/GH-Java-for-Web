package org.geekhub.taras;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamLikeOps {

    private StreamLikeOps() {
    }

    public static <E> List<E> generate(Supplier<E> generator,
                                       Supplier<List<E>> listFactory,
                                       int count) {
        List<E> foodList = listFactory.get();
        for (int i = 0; i < count; i++){
            foodList.add(generator.get());
        }

        return foodList;
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> filterFoodList = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element)) {
                filterFoodList.add(element);
            }
        }

        return filterFoodList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        boolean allMatch = true;
        for (E element : elements) {
            if (!predicate.test(element)) {
                allMatch = false;
                break;
            }
        }

        return allMatch;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return false;
            }
        }
        
        return true;
    }

    public static <T, R> List<R> map(List<T> elements,
                                     Function<T, R> mappingFunction,
                                     Supplier<List<R>> listFactory) {
        //TODO Implement me
        return null;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        return null;
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        return null;
    }

    public static <E> List<E> distinct(List<E> elements, Supplier<List<E>> listFactory) {
        //TODO Implement me
        return null;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        //TODO Implement me
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        return null;
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        return null;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements,
                                                        Predicate<E> predicate,
                                                        Supplier<Map<Boolean, List<E>>> mapFactory,
                                                        Supplier<List<E>> listFactory) {
        //TODO Implement me
        return null;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements,
                                                 Function<T, K> classifier,
                                                 Supplier<Map<K, List<T>>> mapFactory,
                                                 Supplier<List<T>> listFactory) {
        //TODO Implement me
        return null;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction,
                                            Supplier<Map<K, U>> mapFactory) {
        //TODO Implement me
        return null;
    }


    public static <E, T> Map<Boolean, List<T>> partitionByAndMapElement(List<E> elements,
                                                                        Predicate<E> predicate,
                                                                        Supplier<Map<Boolean, List<T>>> mapFactory,
                                                                        Supplier<List<T>> listFactory,
                                                                        Function<E, T> elementMapper) {
        //TODO Implement me
        return null;
    }

    public static <T, U, K> Map<K, List<U>> groupByAndMapElement(List<T> elements,
                                                                 Function<T, K> classifier,
                                                                 Supplier<Map<K, List<U>>> mapFactory,
                                                                 Supplier<List<U>> listFactory,
                                                                 Function<T, U> elementMapper) {
        //TODO Implement me
        return null;
    }

    public static void main(String[] args) {
        Food food = new Food("Fruits", "Apple");
        Supplier<Food> generator = () -> food;
        Supplier<List<Food>> listFactory = ArrayList::new;
        int count = 5;
        List<Food> foodList = generate(generator, listFactory, count);
        new InfoOutput(foodList).printFoodList();

        Food food1 = new Food("Vegetables", "Tomato");
        Food food2 = new Food("Vegetables", "Potato");
        Food food3 = new Food("Vegetables", "Carrot");
        Food food4 = new Food("Bread", "White bread");
        Food food5 = new Food("Bread", "Brown bread");
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        Predicate<Food> filter = f -> f.getFoodType().equalsIgnoreCase("vegetables");
        List<Food> filterFoodList1 = filter(foodList,filter);
        new InfoOutput(filterFoodList1).printFilterFoodList();

        Predicate<Food> predicateAnyMatch1 = p -> p.getTitle().toLowerCase().contains("bread");
        boolean anyMatch1 = anyMatch(foodList,predicateAnyMatch1);
        new InfoOutput(anyMatch1).printAnyMatchBoolean();

        Predicate<Food> predicateAnyMatch2 = p -> p.getTitle().contains("vine");
        boolean anyMatch2 = anyMatch(foodList,predicateAnyMatch2);
        new InfoOutput(anyMatch2).printAnyMatchBoolean();

        Predicate<Food> predicateAllMatch1 = p -> p.getTitle().toLowerCase().contains("a");
        boolean allMatch1 = allMatch(foodList,predicateAllMatch1);
        new InfoOutput(allMatch1).printAllMatchBoolean();

        Predicate<Food> predicateAllMatch2 = p -> p.getTitle().toLowerCase().contains("apple");
        boolean allMatch2 = allMatch(foodList,predicateAllMatch2);
        new InfoOutput(allMatch2).printAllMatchBoolean();

        Predicate<Food> predicateNoneMatch1 = p -> p.getTitle().toLowerCase().contains("water");
        boolean noneMatch1 = noneMatch(foodList,predicateNoneMatch1);
        new InfoOutput(noneMatch1).printNoneMatchBoolean();

        Predicate<Food> predicateNoneMatch2 = p -> p.getTitle().toLowerCase().contains("carrot");
        boolean noneMatch2 = noneMatch(foodList,predicateNoneMatch2);
        new InfoOutput(noneMatch2).printNoneMatchBoolean();
        



    }

}
