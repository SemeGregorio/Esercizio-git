public class Main {

    public static void main(String[] args) {

        //Crea una Person con tutti i campi
        Person person1 = new Builder("Mario", "Rossi").age(30).address("Via DeRoma 17").build();

        //Crea una Person usando solo i campi obbligatori
        Person person2 = new Builder("Luigi", "Verdi").build();

        //Stampa le due persone
        System.out.println(person1);
        System.out.println(person2);
    }
}