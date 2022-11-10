package task1;

import java.util.HashMap;
import java.util.Map;

public class LegalEntity extends Client {
    private String ownerSurname;

    public LegalEntity(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public LegalEntity(){

    }

    Map<Integer, String> idLegalEntityName = new HashMap<>();

    @Override
    public void addClient(Integer id, String name) {
        idLegalEntityName.put(id, name);
    }

    @Override
    public String printNameById() {
        return idLegalEntityName.get(id);
    }

    @Override
    public int printIdByName() {
        return Integer.parseInt(idLegalEntityName.get(name));
    }

    @Override
    public void printInfoClients() {
        for (Integer keys : idLegalEntityName.keySet()) {
            System.out.println("id" + keys + " - " + idLegalEntityName.get(keys));
        }
    }
}
