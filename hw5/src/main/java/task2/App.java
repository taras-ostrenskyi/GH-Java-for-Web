package task2;

import task2.cargo.*;
import task2.engines_wagons.CargoWagon;
import task2.engines_wagons.Locomotive;
import task2.engines_wagons.ProcessType;
import task2.engines_wagons.Train;

import java.util.List;

import static java.lang.System.out;

public class App {
    private static final Station station = new Station();

    public static void main(String[] args) {
        final App app = new App();

        station.add(app.createTrain1());
        station.add(app.createTrain2());
        station.add(app.createTrain3());

        out.println();

        final Train train1 = station.nextTrain();
        app.processTrain(train1, ProcessType.DOWNLOAD);

        final Train train2 = station.nextTrain();
        app.processTrain(train2, ProcessType.DOWNLOAD);

        final Train train3 = station.nextTrain();
        app.processTrain(train3, ProcessType.UNLOAD);
    }

    public void processTrain(Train train, ProcessType processType) {
        out.println(train.getName() + " train processing:");

        final List<CargoWagon<Carriage>> wagons = station.getCargoWagons(train);
        station.process(wagons, processType);

        out.println();
        out.println();
    }

    public Train createTrain1() {
        final Train train = new Train("Northern Express");

        train.addWagon(new Locomotive("L1"));

        for (int i = 0; i < 5; i++) {
            train.addWagon(new CargoWagon<>(new Milk(4)));
        }

        train.addWagon(new Locomotive("L2"));
        train.addWagon(new Locomotive("L3"));

        for (int i = 0; i < 3; i++) {
            train.addWagon(new CargoWagon<>(new Cookies("Jako", 20)));
        }

        train.addWagon(new CargoWagon<>(new Water(45)));
        train.addWagon(new CargoWagon<>(new Cookies("Mary", 23)));
        train.addWagon(new CargoWagon<>(new Water(6)));
        train.addWagon(new CargoWagon<>(new Cookies("Gingerbread", 87)));

        return train;
    }

    public Train createTrain2() {
        final Train train = new Train("Shinkasen");

        train.addWagon(new Locomotive("L1"));

        train.addWagon(new CargoWagon<>(new Sand()));
        train.addWagon(new CargoWagon<>(new Sand()));

        for (int i = 0; i < 4; i++) {
            train.addWagon(new CargoWagon<>(new Gasoline(5)));
        }

        for (int i = 0; i < 3; i++) {
            train.addWagon(new CargoWagon<>(new Cookies("Waffles", 87)));
        }
        train.addWagon(new CargoWagon<>(new Water(9)));

        train.addWagon(new Locomotive("L2"));

        return train;
    }

    public Train createTrain3() {
        final Train train = new Train("Snowpiercer");

        train.addWagon(new CargoWagon<>(new Grain(3)));
        train.addWagon(new CargoWagon<>(new Grain(5)));
        train.addWagon(new CargoWagon<>(new Water(77)));
        train.addWagon(new Locomotive("L1"));

        return train;
    }

}
