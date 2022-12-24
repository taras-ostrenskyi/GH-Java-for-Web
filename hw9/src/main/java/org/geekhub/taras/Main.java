package org.geekhub.taras;

import classes.to.test.hw9.Car;
import classes.to.test.hw9.Cat;
import classes.to.test.hw9.Human;

import javax.swing.text.html.parser.Entity;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Cat cat = new Cat("Black", 3, 4, 35);
        Car car = new Car("black", 190, "Sedan", "RX-7");
        Human human = new Human(180, "male", 22, 75);

        new BeanRepresenter(cat).printView();
        new BeanRepresenter(car).printView();
        new BeanRepresenter(human).printView();

        /*Cat cat = new Cat("white", 2, 4, 40);
        Car car = new Car("grey", 175, "Crossover", "BMW X1");
        Human human = new Human(160, "female", 28, 57);*/

        Cat catClone = new CloneCreator(cat).copy();
        new BeanRepresenter(catClone).printView();



        System.out.println();

    }

}