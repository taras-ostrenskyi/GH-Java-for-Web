package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PreciousMetal extends Asset{

    private final String typeOfmetal = "Gold";
    Double massInKg;
    Double priceUsdKgGold = 49382.72;

    public PreciousMetal(int clientId, Double massInKg){
        this.clientId = clientId;
        this.massInKg = massInKg;
    }

    public PreciousMetal(){

    }

    Map<Integer, Double> idMetalKg = new HashMap<>();

    public void addMetal(Integer clientId, Double massInKg) {
        idMetalKg.put(clientId, massInKg);
    }

    @Override
    public void addAsset(Integer clientId, Integer moneyAmount) {

    }

    @Override
    public double calculateWholePriceUsd() {
        double wholePriceUsd = 0.0;
        for (Integer keys : idMetalKg.keySet()){
            wholePriceUsd += idMetalKg.get(keys) * priceUsdKgGold;
        }
        return wholePriceUsd;
    }

    public Set<Integer> keySet(){
        return idMetalKg.keySet();
    }

    public Double get(Integer key){
        return idMetalKg.get(key);
    }
}
