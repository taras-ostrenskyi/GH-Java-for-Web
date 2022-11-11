package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrentDollarAccount extends Asset {

    int moneyAmount;

    Map<Integer, Integer> idDollarSum = new HashMap<>();

    @Override
    public void addAsset(Integer clientId, Integer moneyAmount) {
        idDollarSum.put(clientId, moneyAmount);
    }

    @Override
    public double calculateWholePriceUsd() {
        double wholePriceUsd = 0.0;
        for (Integer keys : idDollarSum.keySet()){
            wholePriceUsd += idDollarSum.get(keys);
        }
        return wholePriceUsd;
    }

    public Set<Integer> keySet(){
        return idDollarSum.keySet();
    }

    public Integer get(Integer key){
        return idDollarSum.get(key);
    }
}
