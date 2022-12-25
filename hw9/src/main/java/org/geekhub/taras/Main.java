package org.geekhub.taras;

import to.test.hw9.Car;
import to.test.hw9.Cat;
import to.test.hw9.Human;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("black", 3, 4, 35);
        Car car = new Car("black", 190, "Sedan", "RX-7");
        Human human = new Human(180, "male", 22, 75);
        new BeanRepresenter(cat).printView();
        new BeanRepresenter(car).printView();
        new BeanRepresenter(human).printView();

        Cat catClone = new CloneCreator(cat).copy();
        Car carClone = new CloneCreator(car).copy();
        Human humanClone = new CloneCreator(human).copy();
        new BeanRepresenter(catClone).printView();
        new BeanRepresenter(carClone).printView();
        new BeanRepresenter(humanClone).printView();

        Cat catToCompare = new Cat("white", 3, 4, 37);
        Car carToCompare = new Car("black", 175, "Crossover", "BMW X1");
        Human humanToCompare = new Human(160, "female", 22, 57);
        new BeanComparator(cat, catToCompare).compareObjectFields();
        new BeanComparator(car, carToCompare).compareObjectFields();
        new BeanComparator(human, humanToCompare).compareObjectFields();

        System.out.println();
    }
}