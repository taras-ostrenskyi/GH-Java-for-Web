package org.geekhub.taras;

public class Wheel {
    private Tyre tyre;

    public Wheel(Tyre tyre) {
        this.tyre = tyre;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public String toString() {
        return "Wheel{" + "tyre=" + tyre.toString() + "}";
    }
}
