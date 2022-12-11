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
        List<E> eList = listFactory.get();
        for (int i = 0; i < count; i++){
            eList.add(generator.get());
        }
        return eList;
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> filterElist = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element)) {
                filterElist.add(element);
            }
        }
        return filterElist;
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
        List<R> rList = listFactory.get();
        for (T element : elements) {
            rList.add(mappingFunction.apply(element));
        }
        return rList;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        elements.sort(comparator);
        return Optional.of(elements.get(0));
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        elements.sort(comparator);
        return Optional.of(elements.get(0));
    }

    public static <E> List<E> distinct(List<E> elements, Supplier<List<E>> listFactory) {
        List<E> distinctElist = listFactory.get();
        for (int i = 1; i < elements.size(); i++){
            if (!distinctElist.contains(elements.get(i))){
                distinctElist.add(elements.get(i));
            }
        }
        return distinctElist;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
        System.out.println();
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        E e = null;
        for (E element : elements) {
            if (e == null) {
                e = element;
            } else {
                e = accumulator.apply(e, element);
            }
        }
        return Optional.of(e);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E e = seed;
        for (E element : elements) {
            e = accumulator.apply(e, element);
        }
        return e;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements,
                                                        Predicate<E> predicate,
                                                        Supplier<Map<Boolean, List<E>>> mapFactory,
                                                        Supplier<List<E>> listFactory) {
        Map<Boolean, List<E>> booleanListMap = mapFactory.get();
        List<E> trueList = listFactory.get();
        List<E> falseList = listFactory.get();

        for (E element : elements) {
            if (predicate.test(element)) {
                trueList.add(element);
            } else {
                falseList.add(element);
            }
        }

        booleanListMap.put(true, trueList);
        booleanListMap.put(false, falseList);
        return booleanListMap;
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

        Predicate<Food> filter1 = f -> f.getFoodType().equalsIgnoreCase("vegetables");
        List<Food> filterFoodList1 = filter(foodList, filter1);
        new InfoOutput(filterFoodList1).printFilterFoodList();

        Predicate<Food> filter2 = f -> f.getFoodType().equalsIgnoreCase("fruits");
        List<Food> filterFoodList2 = filter(foodList, filter2);
        new InfoOutput(filterFoodList2).printFilterFoodList();

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

        Function<Food, Food> mappingFunction1 = f -> new Food(f.getFoodType(), f.getTitle().toUpperCase());
        List<Food> mapList1 = map(foodList, mappingFunction1, listFactory);
        new InfoOutput(mapList1).printMapList();

        Function<Food, Food> mappingFunction2 = f -> new Food(f.getFoodType(), f.getTitle().toLowerCase());
        List<Food> mapList2 = map(mapList1, mappingFunction2, listFactory);
        new InfoOutput(mapList2).printMapList();

        Comparator<Food> byTitleLength = (Food f1, Food f2) -> Integer.compare(f2.getTitle().length(), f1.getTitle().length());
        Optional<Food> optionalMax = max(foodList, byTitleLength);
        new InfoOutput(optionalMax).printOptionalMax();

        Comparator<Food> byFoodType = Comparator.comparingInt(f -> f.getTitle().length());
        Optional<Food> optionalMin = min(foodList, byFoodType);
        new InfoOutput(optionalMin).printOptionalMin();

        List<Food> distinctFoodList = distinct(foodList, listFactory);
        new InfoOutput(distinctFoodList).printDistinctFoodList();

        Consumer<Food> consumer = f -> new InfoOutput(f).printFood();
        System.out.println("                Usage example   public static <E> void forEach");
        forEach(distinctFoodList, consumer);

        Comparator<Food> comparing = Comparator.comparing(Food::getFoodType);
        BinaryOperator<Food> accumulator1 = BinaryOperator.minBy(comparing);
        Optional<Food> optionalReduse1 = reduce(foodList, accumulator1);
        new InfoOutput(optionalReduse1).printOptionalReduce();

        BinaryOperator<Food> accumulator2 = BinaryOperator.maxBy(comparing);
        Optional<Food> optionalReduse2 = reduce(foodList, accumulator2);
        new InfoOutput(optionalReduse2).printOptionalReduce();

        Food foodReduce1 = reduce(food1, foodList, accumulator1);
        new InfoOutput(foodReduce1).printfoodReduce();

        Food foodReduce2 = reduce(food1, foodList, accumulator2);
        new InfoOutput(foodReduce2).printfoodReduce();

        Predicate<Food> predicateFoodType = f -> f.getFoodType().equalsIgnoreCase("bread");
        Supplier<Map<Boolean, List<Food>>> mapFactory = HashMap::new;
        Map<Boolean, List<Food>> booleanListMap = partitionBy(foodList, predicateFoodType, mapFactory, listFactory);
        new InfoOutput(booleanListMap).printBooleanMap();


    }

}
