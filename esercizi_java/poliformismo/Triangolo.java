public class Triangolo extends Forma {

    private double base;
    private double altezza;

    // Costruttore
    public Triangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    // Override del metodo calcolaArea()
    //Ho sostituito super.calcolaArea con quello che leggete qui sotto
    @Override
    public void calcolaArea() {
        double area = (base * altezza) / 2;
        System.out.println("L'area del triangolo è: " + area);
    }
}