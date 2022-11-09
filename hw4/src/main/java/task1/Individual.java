package task1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Individual extends Client {

    public Individual(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Individual(){

    }

    Map<Integer, String> idIndividualName = new HashMap<>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return null;
        }

        @Override
        public String put(Integer key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<String> values() {
            return null;
        }

        @Override
        public Set<Entry<Integer, String>> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };

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
    public void printInfoAllclients() {
        for (Integer keys : idIndividualName.keySet()) {
            System.out.println("id" + keys + " - " + idIndividualName.get(keys));
        }
    }
}
