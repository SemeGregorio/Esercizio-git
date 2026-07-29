public class Rettangolo extends Forma {

    private double base;
    private double altezza;


    //costruttore
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
        this.tipo = TipoForma.Rettangolo;
    }


    public static void main(String[] args){


        //crea un oggetto rettangolo
        Rettangolo rettangolo = new Rettangolo(5, 3);

        //crea un oggetto triangolo
        Triangolo triangolo = new Triangolo(5, 3);

        //chiama il metodo rettangolo
        rettangolo.calcolaArea();

        //chiama il metodo triangolo
        triangolo.calcolaArea();
    }

    //override del metodo calcolaArea
    @Override
    public void calcolaArea() {
        double area = base * altezza;
        System.out.println("Tipo: " + tipo);
        System.out.println("L'area del rettangolo è: " + area);
    }
}


