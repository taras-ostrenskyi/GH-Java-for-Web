package task1;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public static void main(String[] args) {

        Individual individual = new Individual();
        Information info = new Information();
        individual.addClient(521423457, "Viktor");
        individual.addClient(436588321, "Sergiy");
        individual.addClient(617053415, "Oksana");
        individual.addClient(742651482, "Svitlana");
        individual.addClient(124582346, "Volodymyr");


        System.out.println("The bank's clients - individuals:");

        info.printInfoClients();
        System.out.println();

        LegalEntity legalEntity = new LegalEntity();
        legalEntity.addClient(41524568,"AvtomiSTO");
        legalEntity.addClient(51987325,"Lomaster");
        legalEntity.addClient(74856472,"Bogdan-Avto Cherkasy");
        legalEntity.addClient(95142736,"Bakery CK");
        legalEntity.addClient(69413254,"UPG Cherkasy");

        System.out.println("The bank's clients - legal entities:");
        legalEntity.printInfoClients();

    }
}