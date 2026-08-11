import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class DateEsercizio2Test {

    @Test
    void testData() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Verifica l'anno
        assertEquals(2023, date.getYear());

        //Verifica il mese
        assertEquals(3, date.getMonthValue());

        //Verifica il giorno
        assertEquals(1, date.getDayOfMonth());
    }

    @Test
    void testFormat() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Crea un formatter per il formato richiesto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);

        //Formatta la data
        String result = date.format(formatter);

        //Verifica che il risultato sia quello richiesto
        assertEquals("01 marzo 2023", result);
    }
}