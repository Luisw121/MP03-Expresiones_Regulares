import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Regularexpresion {
    public static void main(String[] args) {
        String texto = "Mi número de teléfono es 123-45-6789. Llama pronto.";
        Pattern pattern = Pattern.compile("\\\\d{3}-\\\\d{2}-\\\\d{4}");
        Matcher matcher = pattern.matcher(texto);

        String newText = matcher.replaceAll("XXX-XX-XXXX");

        System.out.println("Texto modificado: " +newText);

        matcher.reset();

        while (matcher.find()) {
            String numeroTelefono = matcher.group();
            System.out.println("Número de teléfono encontrado: " + numeroTelefono);
        }
    }
}
