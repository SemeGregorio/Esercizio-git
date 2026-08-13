//Non ho capito come usare il Singleton avendo due user...

public class Main {

    public static void main(String[] args) {

        //Crea il primo oggetto User
        User user1 = new User();

        //Stampa le informazioni di default
        user1.stampaInformazioni();

        //Crea il secondo oggetto User
        User user2 = new User();

        //Modifica le informazioni del secondo User
        user2.setNome("Mario");
        user2.setEta(30);

        //Stampa le informazioni modificate
        user2.stampaInformazioni();
    }
}