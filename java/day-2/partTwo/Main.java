import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String filePath = "input.txt";

    public static void main(String[] args) {
        try {
            List<String> strings = readInputFile(Paths.get(filePath));
            outerloop: for (int i = 0; i < strings.size(); i++) {
                for (String string : strings) {
                    int distance = getHammingDistance(strings.get(i), string);
                    if (distance == 1) {
                        System.out.println(getBoxId(strings.get(i), string));
                        // gonna break because we have already found our id
                        break outerloop;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getBoxId(String id1, String id2) {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < id1.length(); i++) {
            if (id1.charAt(i) == id2.charAt(i)) {
                id.append(id1.charAt(i));
            }
        }
        return id.toString();
    }

    private static int getHammingDistance(String source, String target) {
        if (source.length() != target.length())
            return -1;

        int distance = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    private static List<String> readInputFile(Path path) throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}