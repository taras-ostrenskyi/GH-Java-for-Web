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

    public Set<Integer> keySet(){
        return idDollarSum.keySet();
    }

    public Integer get(Integer key){
        return idDollarSum.get(key);
    }
}
