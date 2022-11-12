package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LegalEntity extends Client {
    private String ownerSurname;

    public LegalEntity(int id, String name, String ownerSurname) {
        this.id = id;
        this.name = name;
        this.ownerSurname = ownerSurname;
    }

    public LegalEntity(){

    }

    Map<Integer, String> idLegalEntityName = new HashMap<>();

    @Override
    public void addClient(Integer id, String name) {
        idLegalEntityName.put(id, name);
    }

    public Set<Integer> keySet(){
        return idLegalEntityName.keySet();
    }

    public String get(Integer key){
        return idLegalEntityName.get(key);
    }

}
