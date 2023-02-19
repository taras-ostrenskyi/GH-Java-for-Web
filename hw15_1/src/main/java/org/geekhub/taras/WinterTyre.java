package org.geekhub.taras;

public class WinterTyre extends Tyre{
    private String name;
    private int size;

    public WinterTyre(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return WinterTyre.class.getSimpleName() + " " + getName() + "R" + getSize();
    }
}
