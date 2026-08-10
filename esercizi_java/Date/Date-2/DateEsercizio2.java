import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateEsercizio2 {

    public static void main(String[] args) {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Formatta la data nel formato richiesto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);

        //Stampa la data sulla console
        System.out.println(date.format(formatter));
    }
}