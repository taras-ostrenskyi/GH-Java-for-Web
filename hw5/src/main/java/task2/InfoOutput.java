package task2;

import task2.engines_wagons.Train;

public class InfoOutput {

    Train train;

    public InfoOutput(Train train){
        this.train = train;
    }

    public void infoAddedTrain(){
        System.out.println("Added train: " + train.getName());
    }
}
