import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class PareNoel {
    public static void main(String[] args) {
        String filename= "santako.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int santaCount = 0;
            int renoCount = 0;
            int elfCount = 0;
            Pattern Santapattern = Pattern.compile("\\*<]:-DOo");
            Pattern Renspattern = Pattern.compile(">:o\\)");
            Pattern Folletspattern = Pattern.compile("<]:-D");

            while ((line = reader.readLine()) != null) {
                Matcher santaMatcher = Santapattern.matcher(line);
                while (santaMatcher.find()) {
                    santaCount++;
                }
                Matcher renMatcher = Renspattern.matcher(line);
                while (renMatcher.find()) {
                    renoCount++;
                }
                Matcher elfoMatcher = Folletspattern.matcher(line);
                while (elfoMatcher.find()) {
                    elfCount++;
                }
            }
            System.out.println("Pare noel (" + santaCount + ")");
            System.out.println("Pare Noel (" + renoCount + ")" );
            System.out.println("");
            System.out.println("Follet (" + elfCount + ")");

        } catch (IOException e ) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
