package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Individual extends Client {

    public Individual(){

    }

    Map<Integer, String> idIndividualName = new HashMap<>();

    @Override
    public void addClient(Integer id, String name) {
        idIndividualName.put(id, name);
    }

    /*public String printNameById() {
        return idIndividualName.get(id);
    }

    public int printIdByName() {
        return Integer.parseInt(idIndividualName.get(name));
    }


    public void printInfoClients() {
        for (Integer keys : idIndividualName.keySet()) {
            System.out.println("id" + keys + " - " + idIndividualName.get(keys));
        }
    }*/

    public Set<Integer> keySet(){
        return idIndividualName.keySet();
    }

    public String get(Integer key){
        return idIndividualName.get(key);
    }
}