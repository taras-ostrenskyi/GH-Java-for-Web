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
                int wagonNumber = 1;
                for (CargoWagon<Carriage> wagon : wagons) {
                    if (wagon.entry.unitNumber == 0){
                        System.out.print("/" + wagonNumber + " " + wagon.entry.getClass().getSimpleName() + " ↓");
                    }
                    else{
                        System.out.print("/" + wagonNumber + " " + wagon.entry.getClass().getSimpleName() + " " + wagon.entry.name + wagon.entry.unitNumber + " " + wagon.entry.unit + " ↓");
                    }
                    wagonNumber++;
                }
                break;
            case UNLOAD:
                int wagonNum = 1;
                for (CargoWagon<Carriage> wagon : wagons) {
                    System.out.print("/" + wagonNum + " " + wagon.entry.getClass().getSimpleName() + " " + wagon.entry.name + wagon.entry.unitNumber + " " + wagon.entry.unit + " ↑");
                    wagonNum++;
                }
                break;
            default:

        }
    }
}
