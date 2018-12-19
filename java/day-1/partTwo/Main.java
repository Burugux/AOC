import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final String filePath = "input.txt";

    public static void main(String[] args) {
        try {
            List<String> frequencyList = readInputFile(Paths.get(filePath));
            System.out.println(dupFreq(frequencyList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readInputFile(Path path) throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    private static int dupFreq(List<String> frequencyList) {
        Set<Integer> frequencySet = new HashSet<>();
        frequencySet.add(0);
        int sum = 0;
        for (;;) {
            for (String s : frequencyList) {
                sum += Integer.parseInt(s);
                if (!frequencySet.add(sum)) {
                    return sum;
                }
            }
        }
    }
}
