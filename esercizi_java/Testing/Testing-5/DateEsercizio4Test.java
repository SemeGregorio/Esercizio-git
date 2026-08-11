import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class DateEsercizio4Test {

    @Test
    void testData() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Aggiunge un anno
        data = data.plusYears(1);

        //Sottrae un mese
        data = data.minusMonths(1);

        //Aggiunge 7 giorni
        data = data.plusDays(7);

        //Verifica l'anno
        assertEquals(2024, data.getYear(), "Verifica l'anno");

        //Verifica il mese
        assertEquals(2, data.getMonthValue(), "Verifica il mese");

        //Verifica il giorno
        assertEquals(8, data.getDayOfMonth(), "Verifica il giorno");
    }

    @Test
    void testFormat() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Aggiunge un anno
        data = data.plusYears(1);

        //Sottrae un mese
        data = data.minusMonths(1);

        //Aggiunge 7 giorni
        data = data.plusDays(7);

        //Crea un formatter localizzato per l'Italia
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);

        //Formatta la data
        String risultato = data.format(formatter);

        //Verifica il risultato
        assertEquals("08 febbraio 2024", risultato);
    }
}