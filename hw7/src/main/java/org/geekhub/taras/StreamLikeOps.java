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
        //TODO Implement me
        return null;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        return false;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        return false;
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
        new InfoOutput(generate(generator, listFactory, count)).printFoodList();

    }

}
