package org.geekhub.taras;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SummerTyre extends Tyre{
    private String name;
    private int size;

    @Override
    public String getName() {
        return name;
    }

    @Value("rosava")
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Value("14")
    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return (SummerTyre.class.getSimpleName() + " " + getName() + "R" + getSize());
    }
}
