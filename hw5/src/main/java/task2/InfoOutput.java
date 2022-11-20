package task2;

import task2.cargo.Carriage;
import task2.engines_wagons.CargoWagon;
import task2.engines_wagons.ProcessType;
import task2.engines_wagons.Train;

import java.util.List;

public class InfoOutput {

    Train train;
    Station station;

    public InfoOutput(Train train){
        this.train = train;
    }

    public void infoAddedTrain(){
        System.out.println("Added train: " + train.getName());
    }

}
