public class Triangolo implements Forma {

    private double base;
    private double altezza;

    //Costruttore
    public Triangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    //Override del metodo calcolaArea()
    @Override
    public void calcolaArea() {
        double area = (base * altezza) / 2;
        System.out.println("L'area del triangolo è: " + area);
    }
}
