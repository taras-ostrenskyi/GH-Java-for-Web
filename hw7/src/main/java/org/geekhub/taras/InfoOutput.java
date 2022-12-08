package org.geekhub.taras;

import java.util.List;

public class InfoOutput {
    List<Food> foodList;

    public InfoOutput(){

    }

    public InfoOutput(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void printFoodList(){
        System.out.println("                public static <E> List<E> generate");
        for (Food food : foodList) {
            System.out.println("foodType: " + food.getFoodType() + "   title: " + food.getTitle());
        }
        System.out.println();
    }
}
