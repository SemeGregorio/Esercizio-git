public class Gatto extends Animale {

    //Override del metodo faiIlVerso()
    //Per farlo, ho creato un Override/implement ed ho sostituito "super.FaIlVerso();"
    //con la stringa per stampare il verso, in questo caso del gatto
    @Override
    public void faiIlVerso() {
        System.out.println("Miao");
    }

    public static void main(String[] args) {

        //Crea un oggetto Animale
        Animale animale = new Animale();

        //Crea un oggetto Gatto
        Gatto gatto = new Gatto();

        //Stampa il verso dell'animale
        animale.faiIlVerso();

        //Stampa il verso del gatto
        gatto.faiIlVerso();
    }
}