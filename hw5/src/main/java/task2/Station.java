package task2;

import task2.cargo.Carriage;
import task2.engines_wagons.CargoWagon;
import task2.engines_wagons.ProcessType;
import task2.engines_wagons.Train;

import java.util.ArrayList;
import java.util.List;

public class Station {

    Train train;

    public Station(Train train){
        this.train = train;
    }

    public Station(){

    }

    List<Train> trains = new ArrayList<>();

    public void add(Train train) {
        trains.add(train);
        new InfoOutput(train).infoAddedTrain();
    }

    public Train nextTrain() {
        return null;
    }

    public List<CargoWagon<Carriage>> getCargoWagons(Train train) {
        return train.getWagons();
    }

    public void process(List<CargoWagon<Carriage>> wagons, ProcessType processType) {
        switch (processType){
            case DOWNLOAD:
                System.out.println("Added");
                break;
            case UNLOAD:
                System.out.println("Added");
                break;
            default:

        }

    }
}
