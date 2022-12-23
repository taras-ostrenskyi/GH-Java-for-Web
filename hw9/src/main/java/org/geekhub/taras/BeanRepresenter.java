package org.geekhub.taras;

import classes.to.test.hw9.Car;
import classes.to.test.hw9.Cat;
import classes.to.test.hw9.Human;

import java.lang.reflect.Field;

public class BeanRepresenter {
    public static void main(String[] args) {
        Cat cat = new Cat("Black", 3, 4, 35);
        Car car = new Car("black", 190, "Sedan", "RX-7");
        Human human = new Human(180, "male", 22, 75);

        Class<? extends Cat> catClass = cat.getClass();
        Field[] catFields = catClass.getDeclaredFields();
        new Printer(catClass, catFields, cat).printView();

        Class<? extends Car> carClass = car.getClass();
        Field[] carFields = carClass.getDeclaredFields();
        new Printer(carClass, carFields, car).printView();

        Class<? extends Human> humanClass = human.getClass();
        Field[] humanFields = humanClass.getDeclaredFields();
        new Printer(humanClass, humanFields, human).printView();

        System.out.println();

    }

}