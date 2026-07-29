public class Forma {


    //Enum che identificaa il tipo di forma
    public enum TipoForma {
        Triangolo,
        Rettangolo
    }

    protected TipoForma tipo;


    public void calcolaArea() {
        System.out.println("Area della forma");
    }
}
