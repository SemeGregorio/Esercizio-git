import java.time.OffsetDateTime;

public class DateEsercizio3 {
    public static void main(String[] args) {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime offsetDate = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Stampa i dati sulla console
        System.out.println(offsetDate.getYear());
        System.out.println(offsetDate.getMonth());
        System.out.println(offsetDate.getDayOfMonth());
        System.out.println(offsetDate.getDayOfWeek());
    }
}

