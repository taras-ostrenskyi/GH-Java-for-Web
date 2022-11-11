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
    double uahUsdExchangeRate = 40.5;

    Map<Integer, Integer> idDepositSum = new HashMap<>();

    @Override
    public void addAsset(Integer clientId, Integer moneyAmount) {
        idDepositSum.put(clientId, moneyAmount);
    }

    @Override
    public double calculateWholePriceUsd() {
        double wholePriceUsd = 0.0;
        for (Integer keys : idDepositSum.keySet()){
            wholePriceUsd += idDepositSum.get(keys) / uahUsdExchangeRate;
        }
        return wholePriceUsd;
    }

    public Set<Integer> keySet(){
        return idDepositSum.keySet();
    }

    public Integer get(Integer key){
        return idDepositSum.get(key);
    }
}
