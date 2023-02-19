package org.geekhub.taras;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car summerCar = context.getBean("car", Car.class);
        summerCar.getEngine().showTemper();
        System.out.println(summerCar.getWheels().toString());
    }
}