package task1;

import java.util.HashMap;

public class Information {

    public Information(){

    }

    public void printInfoClients(HashMap hm) {
        for (Object keys : hm.keySet()) {
            System.out.println("id" + keys + " - " + hm.get(keys));
        }
    }

}
