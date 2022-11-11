package task1;

abstract class Asset {

    Integer clientId;

    public abstract void addAsset(Integer clientId, Integer moneyAmount);

    public abstract double calculateWholePriceUsd();
}
