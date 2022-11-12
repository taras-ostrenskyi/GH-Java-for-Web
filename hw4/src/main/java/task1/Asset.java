package task1;

abstract class Asset {

    int clientId;

    public abstract void addAsset(Integer clientId, Integer moneyAmount);

    public abstract double calculateWholePriceUsd();
}
