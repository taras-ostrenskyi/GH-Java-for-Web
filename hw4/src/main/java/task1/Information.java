package task1;

import java.util.HashMap;

public class Information {
    private Individual individual;
    private LegalEntity legalEntity;
    private Deposit deposit;
    private CurrentDollarAccount currentDollarAccount;
    private PreciousMetal preciousMetal;

    public Information(Individual individual){
        this.individual = individual;
    }

    public Information(LegalEntity legalEntity){
        this.legalEntity = legalEntity;
    }

    public Information(Deposit deposit){
        this.deposit = deposit;
    }

    public Information(CurrentDollarAccount currentDollarAccount) {
        this.currentDollarAccount = currentDollarAccount;
    }

    public Information(PreciousMetal preciousMetal){
        this.preciousMetal = preciousMetal;
    }

    public void printInfoIndividual() {
        for (Integer keys : individual.keySet()) {
            System.out.println("id" + keys + " - " + individual.get(keys));
        }
    }

    public void printInfoLegalEntity() {
        for (Integer keys : legalEntity.keySet()) {
            System.out.println("id" + keys + " - " + legalEntity.get(keys));
        }
    }

    public void printInfoDeposit() {
        for (Integer keys : deposit.keySet()) {
            System.out.println("id" + keys + " - " + deposit.get(keys));
        }
    }

    public void printInfoCurrentDollarAccount() {
        for (Integer keys : currentDollarAccount.keySet()) {
            System.out.println("id" + keys + " - " + currentDollarAccount.get(keys));
        }
    }

    public void printInfoPreciousMetal() {
        for (Integer keys : preciousMetal.keySet()) {
            System.out.println("id" + keys + " - " + preciousMetal.get(keys));
        }
    }

}
