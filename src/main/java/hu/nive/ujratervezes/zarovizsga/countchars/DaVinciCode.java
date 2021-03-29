package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class DaVinciCode {

    public static final List<Character> CRITERION = Arrays.asList('0', '1', 'x');

    public int encode(String path, Character character) {
        if (!CRITERION.contains(character)) {
            throw new IllegalArgumentException("Invalid character");
        }
        int result = 0;
        Path file = Path.of(path);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                for (Character c : line.toCharArray()) {
                    if (c == character) {
                        result++;
                    }
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
        return result;
    }
}
