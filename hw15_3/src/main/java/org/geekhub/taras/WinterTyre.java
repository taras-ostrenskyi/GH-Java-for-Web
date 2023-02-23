package org.geekhub.taras;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WinterTyre extends Tyre{
    private String name;
    private int size;

    @Override
    public String getName() {
        return name;
    }

    @Value("${winterTyre.name}")
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Value("${winterTyre.size}")
    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return WinterTyre.class.getSimpleName() + " " + getName() + "R" + getSize();
    }
}