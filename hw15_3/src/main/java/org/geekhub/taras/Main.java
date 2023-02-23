package org.geekhub.taras;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Car summerCar = context.getBean("car", Car.class);
        summerCar.getEngine().showTemper();
        System.out.println(summerCar.getWheels().toString());
    }
}