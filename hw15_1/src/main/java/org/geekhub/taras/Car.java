package org.geekhub.taras;

import java.util.List;

public class Car {
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(Engine engine, List<Wheel> wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }
}
