import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String filePath = "input.txt";

    public static void main(String[] args) {
        try {
            List<String> strings = readInputFile(Paths.get(filePath));

            int twos = 0;
            int threes = 0;
            for (String s : strings) {
                Map<Character, Integer> map = new HashMap<>();
                for (Character c : s.toCharArray()) {
                    map.merge(c, 1, Integer::sum);
                }
                if (map.containsValue(2)) {
                    twos++;
                }
                if (map.containsValue(3)) {
                    threes++;
                }
            }

            System.out.println(twos * threes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readInputFile(Path path) throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
