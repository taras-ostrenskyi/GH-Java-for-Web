package task1;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public static void main(String[] args) {

        Individual individual = new Individual();
        individual.addClient(521423457, "Viktor");
        individual.addClient(436588321, "Sergiy");
        individual.addClient(617053415, "Oksana");
        individual.addClient(742651482, "Svitlana");
        individual.addClient(124582346, "Volodymyr");

        System.out.println("The bank's clients - individuals:");
        Information infoIndivid = new Information(individual);
        infoIndivid.printInfoIndividual();
        System.out.println();

        LegalEntity legalEntity = new LegalEntity();
        legalEntity.addClient(41524568,"AvtomiSTO");
        legalEntity.addClient(51987325,"Lomaster");
        legalEntity.addClient(74856472,"Bogdan-Avto Cherkasy");
        legalEntity.addClient(95142736,"Bakery CK");
        legalEntity.addClient(69413254,"UPG Cherkasy");

        System.out.println("The bank's clients - legal entities:");
        Information infoEntity = new Information(legalEntity);
        infoEntity.printInfoLegalEntity();
        System.out.println();

        Deposit deposit = new Deposit();
        deposit.addAsset(436588321, 14000);
        deposit.addAsset(617053415, 25000);
        deposit.addAsset(51987325,150000);
        deposit.addAsset(74856472,500000);

        System.out.println("The bank's clients - UAH deposits:");
        Information infoDeposit = new Information(deposit);
        infoDeposit.printInfoDeposit();
        System.out.println();

        CurrentDollarAccount currentDollarAccount = new CurrentDollarAccount();
        currentDollarAccount.addAsset(521423457, 2500);
        currentDollarAccount.addAsset(436588321, 300);
        currentDollarAccount.addAsset(51987325,1500);
        currentDollarAccount.addAsset(124582346, 2000);

        System.out.println("The bank's clients - current dollars accounts:");
        Information infoCurrentDollarAccount = new Information(currentDollarAccount);
        infoCurrentDollarAccount.printInfoCurrentDollarAccount();
        System.out.println();

        PreciousMetal preciousMetal = new PreciousMetal();
        preciousMetal.addMetal(742651482, 0.02);
        preciousMetal.addMetal(124582346, 0.07);
        preciousMetal.addMetal(95142736,0.1);
        preciousMetal.addMetal(69413254, 1.1);

        System.out.println("The bank's clients - gold in storage, kg:");
        Information infoPreciousMetal = new Information(preciousMetal);
        infoPreciousMetal.printInfoPreciousMetal();
        System.out.println();

        System.out.println("The value of the bank's assets in US dollars:");

    }
}