package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish {
    public Tang(String name, int weight, String color) {
        super(name, weight, color);
        setMemoryLoss(true);
    }

    @Override
    void feed() {
        incrementWeight(1);
    }
}
