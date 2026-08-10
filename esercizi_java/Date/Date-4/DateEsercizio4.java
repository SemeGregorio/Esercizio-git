import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateEsercizio4 {

    public static void main(String[] args) {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime offsetDate = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Aggiunge un anno
        offsetDate = offsetDate.plusYears(1);

        //Sottrae un mese
        offsetDate = offsetDate.minusMonths(1);

        //Aggiunge 7 giorni
        offsetDate = offsetDate.plusDays(7);

        //Crea un formato localizzato per l'Italia
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);

        // Stampa il risultato
        System.out.println(offsetDate.format(formatter));
    }
}