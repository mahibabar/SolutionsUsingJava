import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        final Path source = Paths.get("test/mb.json");
        Path dest = Paths.get("test/mb1.json");

        try {
            Files.copy(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
