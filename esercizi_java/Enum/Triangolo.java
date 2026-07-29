public class Triangolo extends Forma {

    private double base;
    private double altezza;

    //costruttore
    public Triangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
        this.tipo = TipoForma.Triangolo;
    }


    //override del metodo calcolaArea
    @Override
    public void calcolaArea() {
        double area = (base * altezza) / 2;
        System.out.println("Tipo: " + tipo);
        System.out.println("L'area del triangolo è: " + area);
    }
}
