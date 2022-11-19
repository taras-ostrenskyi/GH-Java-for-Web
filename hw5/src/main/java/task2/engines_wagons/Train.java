package task2.engines_wagons;

import task2.cargo.Carriage;

import java.util.ArrayList;
import java.util.List;

public class Train {

    String name;

    public Train (String name){
        this.name = name;
    }

    List<CargoWagon<Carriage>> wagons = new ArrayList<>();

    public void addWagon(Locomotive name) {

    }

    public List<CargoWagon<Carriage>> getWagons() {
        return wagons;
    }

    public void addWagon(CargoWagon<Carriage> cargoWagon){
        wagons.add(cargoWagon);
    }

    public String getName() {
        return name;
    }
}
