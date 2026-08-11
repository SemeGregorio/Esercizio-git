import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.junit.jupiter.api.Assertions.*;

class DateEsercizio1Test {

    @Test
    void testData() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime data = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        //Verifica l'anno
        assertEquals(2002, data.getYear());

        //Verifica il mese
        assertEquals(3, data.getMonthValue());

        //Verifica il giorno
        assertEquals(1, data.getDayOfMonth());

        //Verifica l'ora
        assertEquals(13, data.getHour());


    }
    @Test
    void testFull() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        //Coverte OffesetDateTime in ZoneDateTime
        ZonedDateTime zonedDate = date.atZoneSameInstant(ZoneId.of("UTC"));

        //Crea un formatter per il formato Full
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        //Formatta la data nel formato Full
        String result = zonedDate.format(formatter);

        assertNotNull(result, "Verifica che il risultato non sia null");
        assertFalse(result.isEmpty(),"Verifica che il risultato non sia vuoto");
    }

    @Test
    void testMedium() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        //Coverte OffesetDateTime in ZoneDateTime
        ZonedDateTime zonedDate = date.atZoneSameInstant(ZoneId.of("UTC"));

        //Crea un formatter per il formato medium
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        //Formatta la data nel formato Medium
        String result = zonedDate.format(formatter);

        assertNotNull(result, "Verifica che il risultato non sia null");
        assertFalse(result.isEmpty(),"Verifica che il risultato non sia vuoto");
    }

    @Test
    void testShort() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime date = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        //Coverte OffesetDateTime in ZoneDateTime
        ZonedDateTime zonedDate = date.atZoneSameInstant(ZoneId.of("UTC"));

        //Crea un formatter per il formato short
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        //Formatta la data nel formato short
        String result = zonedDate.format(formatter);

        assertNotNull(result, "Verifica che il risultato non sia null");
        assertFalse(result.isEmpty(),"Verifica che il risultato non sia vuoto");
    }

}