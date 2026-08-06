//L'esercizio l'ho svolto in un unico file,
//poiché tutte le operazioni richieste dalla traccia possono essere gestite in questa classe.

import java.util.HashSet;

public class HashSetEsercizio2 {

    //Metodo che crea e restituisce un HashSet
    public static HashSet<String> creaHashSet() {

        //Crea un HashSet
        HashSet<String> insieme = new HashSet<>();

        //Aggiunge alcuni elementi
        insieme.add("Louis");
        insieme.add("Niko");
        insieme.add("Johnny");

        //Restituisce l'HashSet
        return insieme;
    }

    public static void main(String[] args) {

        //Chiama il metodo
        HashSet<String> insieme = creaHashSet();

        //Crea un oggetto dello stesso tipo inserito nell'HashSet
        String elemento = "Niko";

        //Verifica se l'elemento è presente nell'HashSet
        boolean presente = insieme.contains(elemento);

        //Stampa il risultato
        System.out.println("L'elemento è presente nell'HashSet? " + presente);
    }
}