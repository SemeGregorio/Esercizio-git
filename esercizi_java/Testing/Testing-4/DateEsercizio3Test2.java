import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateEsercizio3Test2 {

    @Test
    void testData() {

        //Crea un oggetto OffsetDateTime dalla stringa
        OffsetDateTime data =
                OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Verifica l'anno
        assertEquals(2023, data.getYear(), "Verifica l'anno");

        //Verifica il mese
        assertEquals(3, data.getMonthValue(), "Verifica il mese");

        //Verifica il giorno
        assertEquals(1, data.getDayOfMonth(), "Verifica il giorno");

        //Verifica il giorno della settimana
        assertEquals(3, data.getDayOfWeek().getValue(), "Verifica il giorno della settimana");
    }
}