package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        List<Character> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!result.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }

}
