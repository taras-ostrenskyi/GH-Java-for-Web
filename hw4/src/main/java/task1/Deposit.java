package task1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Deposit extends Asset {
    String currency = "UAH";
    LocalDate startDate;
    int moneyAmount;
    int yearPercent;

    Map<Integer, Integer> idDepositSum = new HashMap<>();

    @Override
    public void addAsset(Integer clientId, Integer moneyAmount) {
        idDepositSum.put(clientId, moneyAmount);
    }

    public Set<Integer> keySet(){
        return idDepositSum.keySet();
    }

    public Integer get(Integer key){
        return idDepositSum.get(key);
    }
}
