package org.geekhub.taras;

public class Food {
    private final String foodType;
    private final String title;

    public Food(String foodType, String title){
        this.foodType = foodType;
        this.title = title;
    }

    public String getFoodType(){
        return foodType;
    }

    public String getTitle(){
        return title;
    }


}
