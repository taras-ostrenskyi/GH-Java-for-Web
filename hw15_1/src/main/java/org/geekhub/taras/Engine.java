package org.geekhub.taras;

public class Engine {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void showTemper() {
        System.out.println();
        System.out.println("Capacity: " + getCapacity());
        System.out.println("R-r-r-r-r");
    }

}
