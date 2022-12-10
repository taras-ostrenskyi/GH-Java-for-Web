package org.geekhub.taras;

import java.util.List;
import java.util.Optional;

public class InfoOutput {
    List<Food> foodList;
    Boolean variable;
    Optional<Food> optional;

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

    public void printFoodList(){
        System.out.println("                Usage example   public static <E> List<E> generate");
        for (Food food : foodList) {
            System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        }
        System.out.println();
    }

    public void printFilterFoodList(){
        System.out.println("                Usage example   public static <E> List<E> filter");
        for (Food food : foodList) {
            System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        }
        System.out.println();
    }

    public void printAnyMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean anyMatch");
        System.out.println(variable);
        System.out.println();
    }

    public void printAllMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean allMatch");
        System.out.println(variable);
        System.out.println();
    }

    public void printNoneMatchBoolean(){
        System.out.println("                Usage example   public static <E> boolean noneMatch");
        System.out.println(variable);
        System.out.println();
    }

    public void printMapList(){
        System.out.println("                Usage example   public static <T, R> List<R> map");
        for (Food food : foodList) {
            System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        }
        System.out.println();

    }

    public void printFoodOptional(){
        System.out.println("                Usage example   public static <E> Optional<E> max  or  public static <E> Optional<E> min");
        if (optional.isPresent()){
            System.out.println("foodType: " + optional.get().getFoodType() + "   title: " + optional.get().getTitle());
        }
        else{
            System.out.println("No value present");
        }
        System.out.println();

    }


}
