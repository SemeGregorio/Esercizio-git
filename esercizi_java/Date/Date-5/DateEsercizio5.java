import java.time.OffsetDateTime;

public class DateEsercizio5 {

    public static void main(String[] args) {

        //Crea il primo oggetto OffsetDateTime dalla stringa
        OffsetDateTime primaData = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //Crea il secondo oggetto OffsetDateTime dalla stringa
        OffsetDateTime secondaData = OffsetDateTime.parse("2024-03-01T13:00:00Z");

        //Verifica che la prima data sia precedente alla seconda
        System.out.println("La prima data è precedente alla seconda? "+ primaData.isBefore(secondaData));

        //Verifica che la seconda data sia successiva alla prima
        System.out.println("La seconda data è successiva alla prima? " + secondaData.isAfter(primaData));

        //Verifica che le due date abbiano la stessa ora
        System.out.println("Le due date hanno lo stesso orario? " + primaData.toLocalTime().equals(secondaData.toLocalTime()));
    }
}