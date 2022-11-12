package task1;

public class InfoOutput {

    private int clientId;
    private Individual individual;
    private LegalEntity legalEntity;
    private Deposit deposit;
    private CurrentDollarAccount currentDollarAccount;
    private PreciousMetal preciousMetal;

    public InfoOutput(Individual individual){
        this.individual = individual;
    }

    public InfoOutput(LegalEntity legalEntity){
        this.legalEntity = legalEntity;
    }

    public InfoOutput(Deposit deposit){
        this.deposit = deposit;
    }

    public InfoOutput(Deposit deposit, int clientId){
        this.deposit = deposit;
        this.clientId = clientId;
    }

    public InfoOutput(CurrentDollarAccount currentDollarAccount) {
        this.currentDollarAccount = currentDollarAccount;
    }

    public InfoOutput(CurrentDollarAccount currentDollarAccount, int clientId){
        this.currentDollarAccount = currentDollarAccount;
        this.clientId = clientId;
    }

    public InfoOutput(PreciousMetal preciousMetal){
        this.preciousMetal = preciousMetal;
    }

    public InfoOutput(PreciousMetal preciousMetal, int clientId){
        this.preciousMetal = preciousMetal;
        this.clientId = clientId;
    }

    public InfoOutput(Deposit deposit, CurrentDollarAccount currentDollarAccount, PreciousMetal preciousMetal){
        this.deposit = deposit;
        this.currentDollarAccount = currentDollarAccount;
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

    public void printWholePriceAssets(){
        System.out.println(deposit.calculateWholePriceUsd() + currentDollarAccount.calculateWholePriceUsd()
                + preciousMetal.calculateWholePriceUsd());
    }

    public void printInfoDepositFind() {
        if (deposit.get(clientId) != null) {
            System.out.println("id" + clientId + " - " + deposit.get(clientId));
        }
        else{
            System.out.println("id" + clientId + " - 0");
        }
        }

    public void printInfoDollarAccountFind() {
        if (currentDollarAccount.get(clientId) != null) {
            System.out.println("id" + clientId + " - " + currentDollarAccount.get(clientId));
        }
        else{
            System.out.println("id" + clientId + " - 0");
        }
    }public void printInfoPreciousMetalFind() {
        if (preciousMetal.get(clientId) != null) {
            System.out.println("id" + clientId + " - " + preciousMetal.get(clientId));
        }
        else{
            System.out.println("id" + clientId + " - 0");
        }
    }



    }


