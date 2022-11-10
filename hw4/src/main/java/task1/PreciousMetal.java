package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PreciousMetal extends Asset{

    String typeOfmetal = "Gold";
    Double massInKg;
    Double priceKgGold = 2000000.0;

    Map<Integer, Double> idMetalKg = new HashMap<>();

    public void addMetal(Integer clientId, Double massInKg) {
        idMetalKg.put(clientId, massInKg);
    }

    @Override
    public void addAsset(Integer clientId, Integer moneyAmount) {

    }

    public Set<Integer> keySet(){
        return idMetalKg.keySet();
    }

    public Double get(Integer key){
        return idMetalKg.get(key);
    }
}