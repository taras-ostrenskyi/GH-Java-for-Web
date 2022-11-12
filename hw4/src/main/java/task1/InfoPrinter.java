package task1;

public class InfoPrinter {

    private int clientId;
    private Individual individual;
    private LegalEntity legalEntity;
    private Deposit deposit;
    private CurrentDollarAccount currentDollarAccount;
    private PreciousMetal preciousMetal;

    public InfoPrinter(Individual individual){
        this.individual = individual;
    }

    public InfoPrinter(LegalEntity legalEntity){
        this.legalEntity = legalEntity;
    }

    public InfoPrinter(Deposit deposit){
        this.deposit = deposit;
    }

    public InfoPrinter(Deposit deposit, int clientId){
        this.deposit = deposit;
        this.clientId = clientId;
    }

    public InfoPrinter(CurrentDollarAccount currentDollarAccount) {
        this.currentDollarAccount = currentDollarAccount;
    }

    public InfoPrinter(PreciousMetal preciousMetal){
        this.preciousMetal = preciousMetal;
    }

    public InfoPrinter(Deposit deposit, CurrentDollarAccount currentDollarAccount, PreciousMetal preciousMetal){
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
            System.out.println("id" + clientId + " - " + deposit.get(clientId));
    }

}
