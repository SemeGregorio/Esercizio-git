public class Rettangolo extends Forma {

    private double base;
    private double altezza;

    //Costruttore
    public Rettangolo(double base, double altezza) {
        super(base * altezza);
        this.base = base;
        this.altezza = altezza;
    }

    //Override del metodo calcolaArea()
    @Override
    public void calcolaArea() {
        double area = base * altezza;
        System.out.println("L'area del rettangolo è: " + area);
    }

    public static void main(String[] args) {

        //Crea un oggetto Forma
        Forma forma = new Forma(20);

        //Crea un oggetto Rettangolo
        Rettangolo rettangolo = new Rettangolo(5, 3);

        //Stampa l'area della forma
        forma.calcolaArea();

        //Calcola e stampa l'area del rettangolo
        rettangolo.calcolaArea();
    }
}