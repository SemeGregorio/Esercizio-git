//L'esercizio l'ho svolto in un unico file,
//poiché tutte le operazioni richieste dalla traccia possono essere gestite in questa classe.


import java.util.HashSet;
import java.util.Iterator;

public class HashSetEsercizio3 {

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

        //Chiama il metodo per creare l'HashSet
        HashSet<String> insieme = creaHashSet();

        //Crea un oggetto dello stesso tipo inserito nell'HashSet
        String elementoDaEliminare = "Niko";

        //Crea un Iterator per scorrere l'HashSet
        Iterator<String> iterator = insieme.iterator();

        //Scorre tutti gli elementi dell'HashSet
        while (iterator.hasNext()) {

            //Prende l'elemento corrente
            String elemento = iterator.next();

            //Controlla se l'elemento è uguale a quello creato
            if (elemento.equals(elementoDaEliminare)) {

                //Elimina l'elemento dall'HashSet
                iterator.remove();
            }
        }

        //Stampa gli elementi rimasti nell'HashSet
        System.out.println("Elementi rimasti dopo la rimozione:");

        for (String elemento : insieme) {
            System.out.println(elemento);
        }

        //Svuota completamente l'HashSet
        insieme.clear();

        //Verifica se l'HashSet è vuoto e stampa il risultato
        System.out.println("L'HashSet dopo il clear è vuoto? " + insieme.isEmpty());
    }
}