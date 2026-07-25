public class Forma {

    private double area;

    //Costruttore
    public Forma(double area) {
        this.area = area;
    }

    //Metodo che stampa l'area della forma
    public void calcolaArea() {
        System.out.println("L'area della forma è: " + area);
    }
}