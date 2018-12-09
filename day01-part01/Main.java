import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    //enter path to input file
    private static final String filePath = "";

    public static void main(String[] args) {
        try {
            List<String> inputString = readInputFile();
            int i = 0;
            for (String s : inputString) {
                i += Integer.parseInt(s);
            }
            System.out.println(i);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readInputFile() throws IOException {
        Path path = Paths.get(Main.filePath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
