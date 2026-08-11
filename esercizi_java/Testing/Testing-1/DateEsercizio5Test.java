import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateEsercizio5Test {

    @Test
    void testDate() {

        //le date che dobbiamo controllare
        OffsetDateTime primaData = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        OffsetDateTime secondaData = OffsetDateTime.parse("2024-03-01T13:00:00Z");

        //Verifica che queste condizioni siano vere
        assertTrue(primaData.isBefore(secondaData),"La prima data deve essere precedente alla seconda");
        assertTrue(secondaData.isAfter(primaData),"La seconda data deve essere successiva alla prima");
        assertTrue(primaData.toLocalTime().equals(secondaData.toLocalTime()),"Le date devono avere lo stesso orario");
    }
}