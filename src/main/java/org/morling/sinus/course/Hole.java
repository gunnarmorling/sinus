package org.morling.sinus.course;

public class Hole {

    private final int par;
    private final int difficultyOrder;

    public Hole(int par, int difficultyOrder) {
        this.par = par;
        this.difficultyOrder = difficultyOrder;
    }

    @Override
    public String toString() {
        return "Hole [par=" + par + ", difficultyOrder=" + difficultyOrder + "]";
    }
}
