package task2;

import task2.cargo.Carriage;
import task2.engines_wagons.CargoWagon;
import task2.engines_wagons.ProcessType;
import task2.engines_wagons.Train;

import java.util.ArrayList;
import java.util.List;

public class Station {

    public Station(){

    }

    List<Train> trains = new ArrayList<>();

    public void add(Train train) {
        trains.add(train);
        new InfoOutput(train).infoAddedTrain();
    }

    public Train nextTrain() {
        Train trainFirst = trains.get(0);
        trains.remove(0);
        return trainFirst;
    }

    public List<CargoWagon<Carriage>> getCargoWagons(Train train) {
        return train.getWagons();
    }

    public void process(List<CargoWagon<Carriage>> wagons, ProcessType processType) {
        switch (processType){
            case DOWNLOAD:
                new InfoOutput(wagons).infoWagonDownload();
                break;
            case UNLOAD:
                new InfoOutput(wagons).infoWagonUnload();
                break;
            default:

        }
    }
}
