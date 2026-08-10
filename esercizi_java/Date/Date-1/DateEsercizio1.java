import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateEsercizio1 {

    public static void main(String[] args) {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        //Converte OffsetDateTime in ZonedDateTime
        ZonedDateTime zonedDate = date.atZoneSameInstant(ZoneId.of("UTC"));

        //Stampa la data in formato FULL
        System.out.println("Date Full: " + zonedDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));

        //Stampa la data in formato MEDIUM
        System.out.println("Date Medium: " + zonedDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        //Stampa la data in formato SHORT
        System.out.println("Date Short: " + zonedDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }
}