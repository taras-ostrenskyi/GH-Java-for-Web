package task2;

import task2.cargo.Carriage;
import task2.engines_wagons.CargoWagon;
import task2.engines_wagons.Train;

import java.util.List;

public class InfoOutput {

    List<CargoWagon<Carriage>> wagons;
    Train train;

    public InfoOutput(List<CargoWagon<Carriage>> wagons){
        this.wagons = wagons;

    }

    public InfoOutput(Train train){
        this.train = train;
    }

    public void infoAddedTrain(){
        System.out.println("Added train: " + train.getName());
    }

    public void infoWagonDownload() {
        int wagonNumber = 1;
        for (CargoWagon<Carriage> wagon : wagons) {
            if (wagon.entry.unitNumber == 0) {
                System.out.print("/" + wagonNumber + " " + wagon.entry.getClass().getSimpleName() + " ↓");
            } else {
                System.out.print("/" + wagonNumber + " " + wagon.entry.getClass().getSimpleName() + " " + wagon.entry.name + wagon.entry.unitNumber + " " + wagon.entry.unit + " ↓");
            }
            wagonNumber++;
        }
    }

    public void infoWagonUnload(){
        int wagonNum = 1;
        for (CargoWagon<Carriage> wagon : wagons) {
            System.out.print("/" + wagonNum + " " + wagon.entry.getClass().getSimpleName() + " " + wagon.entry.name + wagon.entry.unitNumber + " " + wagon.entry.unit + " ↑");
            wagonNum++;
        }
    }

}
