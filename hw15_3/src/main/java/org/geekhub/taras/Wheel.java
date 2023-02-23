package org.geekhub.taras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Wheel {
    private Tyre tyre;

    public Tyre getTyre() {
        return tyre;
    }

    @Autowired
    @Qualifier("summerTyre")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public String toString() {
        return "Wheel{" + "tyre=" + tyre.toString() + "}";
    }
}
