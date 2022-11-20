package task2.engines_wagons;

import task2.cargo.Carriage;

public class CargoWagon<T extends Carriage> {
    public T entry;

    public CargoWagon(T entry) {
        this.entry = entry;
    }

    public CargoWagon(){

    }
}
