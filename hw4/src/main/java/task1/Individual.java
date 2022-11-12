package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Individual extends Client {

    public Individual(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Individual(){

    }

    Map<Integer, String> idIndividualName = new HashMap<>();

    @Override
    public void addClient(Integer id, String name) {
        idIndividualName.put(id, name);
    }

    public Set<Integer> keySet(){
        return idIndividualName.keySet();
    }

    public String get(Integer key){
        return idIndividualName.get(key);
    }
}
