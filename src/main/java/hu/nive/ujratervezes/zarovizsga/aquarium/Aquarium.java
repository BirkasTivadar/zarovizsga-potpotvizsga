package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        fishes.forEach(f -> f.feed());
//        for (Fish fish : fishes) {
//            fish.feed();
//        }
    }

    public void removeFish() {
        this.fishes = fishes.stream().filter(f -> f.getWeight() < 11).collect(Collectors.toList());

//        List<Fish> temp = new ArrayList<>();
//        for (Fish fish : fishes) {
//            if (fish.getWeight() >= 11) {
//                temp.add(fish);
//            }
//        }
//        fishes.removeAll(temp);
    }

    public List<String> getStatus() {
        return fishes.stream().map(f -> f.status()).collect(Collectors.toList());
//        List<String> result = new ArrayList<>();
//        for (Fish fish : fishes) {
//            result.add(fish.status());
//        }
//        return result;
    }
}
