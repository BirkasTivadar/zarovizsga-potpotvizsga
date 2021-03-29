package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish() {
        List<Fish> temp = new ArrayList<>();
        for (Fish fish : fishes) {
            if (fish.getWeight() >= 11) {
                temp.add(fish);
            }
        }
        fishes.removeAll(temp);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish : fishes) {
            result.add(fish.status());
        }
        return result;
    }
}
