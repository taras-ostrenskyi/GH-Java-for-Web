package task1;

import java.util.HashMap;
import java.util.Map;

public class Individual extends Client {

    public Individual(){

    }

    Map<Integer, String> idIndividualName = new HashMap<>();

    @Override
    public void addClient(Integer id, String name) {
        idIndividualName.put(id, name);
    }

    @Override
    public String printNameById() {
        return idIndividualName.get(id);
    }

    @Override
    public int printIdByName() {
        return Integer.parseInt(idIndividualName.get(name));
    }

    @Override
    public void printInfoClients() {
        for (Integer keys : idIndividualName.keySet()) {
            System.out.println("id" + keys + " - " + idIndividualName.get(keys));
        }
    }
}
