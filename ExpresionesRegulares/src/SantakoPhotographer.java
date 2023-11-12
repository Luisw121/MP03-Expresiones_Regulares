import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantakoPhotographer {
    public static void main(String[] args) {
        String filename = "santako.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int casa = 1;

            while ((line = reader.readLine()) != null) {
                int santaCount = 0;
                int reindeerCount = 0;
                int elfCount = 0;

                Pattern santaPattern = Pattern.compile("\\*<]:-DOo");
                Pattern reindeerPattern = Pattern.compile(">:o\\)");
                Pattern elfPattern = Pattern.compile("<]:-D");

                Matcher santaMatcher = santaPattern.matcher(line);
                while (santaMatcher.find()) {
                    santaCount++;
                }

                Matcher reindeerMatcher = reindeerPattern.matcher(line);
                while (reindeerMatcher.find()) {
                    reindeerCount++;
                }

                Matcher elfMatcher = elfPattern.matcher(line);
                while (elfMatcher.find()) {
                    elfCount++;
                }

                if (casa == 1) {
                    System.out.println("Pare Noel (" + santaCount + ")");
                } else if (casa == 2) {
                    System.out.println("Pare Noel (" + santaCount + ") Ren (" + reindeerCount + ")");
                } else if (casa == 4) {
                    System.out.println("Follet (" + elfCount + ")");
                } else if (casa == 3) {
                    System.out.println();
                }

                casa++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
