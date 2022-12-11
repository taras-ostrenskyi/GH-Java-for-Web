package org.geekhub.taras;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InfoOutput {
    List<Food> foodList;
    Boolean variable;
    Optional<Food> optional;
    Food food;
    Map<Boolean, List<Food>> booleanListMap;

    public InfoOutput(){

    }

    public InfoOutput(List<Food> foodList) {
        this.foodList = foodList;
    }

    public InfoOutput(Boolean variable){
        this.variable = variable;
    }

    public InfoOutput(Optional<Food> optional){
        this.optional = optional;
    }

    public InfoOutput(Food food){
        this.food = food;
    }

    public InfoOutput(Map<Boolean, List<Food>> booleanListMap){
        this.booleanListMap = booleanListMap;
    }

    public void printList(){
        for (Food food : foodList) {
            System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        }
        System.out.println();
    }

    public void printFoodList(){
        System.out.println("                Usage example   public static <E> List<E> generate");
        printList();
    }

    public void printFilterFoodList(){
        System.out.println("                Usage example   public static <E> List<E> filter");
        printList();
    }

    public void printVariable(){
        System.out.println(variable);
        System.out.println();
    }

    public void printAnyMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean anyMatch");
        printVariable();
    }

    public void printAllMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean allMatch");
        printVariable();
    }

    public void printNoneMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean noneMatch");
        printVariable();
    }

    public void printMapList(){
        System.out.println("                Usage example   public static <T, R> List<R> map");
        printList();
    }

    public void printFoodOptional(){
        if (optional.isPresent()){
            System.out.println("foodType: " + optional.get().getFoodType() + "   title: " + optional.get().getTitle());
        }
        else{
            System.out.println("No value present");
        }
        System.out.println();
    }

    public void printOptionalMax(){
        System.out.println("                Usage example   public static <E> Optional<E> max");
        printFoodOptional();
    }

    public void printOptionalMin(){
        System.out.println("                Usage example   public static <E> Optional<E> min");
        printFoodOptional();
    }

    public void printDistinctFoodList(){
        System.out.println("                Usage example   public static <E> List<E> distinct");
        printList();
    }

    public void printFood(){
        System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        System.out.println();
    }

    public void printOptionalReduce(){
        System.out.println("                Usage example   public static <E> Optional<E> reduce");
        printFoodOptional();
    }

    public void printfoodReduce(){
        System.out.println("                Usage example   public static <E> E reduce");
        printFood();
    }

    public void printBoolMap(){
        for (Boolean keys : booleanListMap.keySet())
        {
            System.out.println(keys + ":");
            for (Food food : booleanListMap.get(keys)) {
                    System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
            }
        }
        System.out.println();
    }

    public void printBooleanMap(){
        System.out.println("                Usage example   public static <E> Map<Boolean, List<E>> partitionBy");
        printBoolMap();

    }


}
