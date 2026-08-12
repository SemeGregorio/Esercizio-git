public class Main {

    public static void main(String[] args) {

        //Crea una nuova Factory
        ShapeFactory factory = new ShapeFactory();

        //Crea un cerchio tramite la Factory
        Shape circle = factory.getShape(ShapeType.CIRCLE);

        //Crea un rettangolo tramite la Factory
        Shape rectangle = factory.getShape(ShapeType.RECTANGLE);

        //Stampa il risultato del metodo draw del cerchio
        circle.draw();

        //Stampa il risultato del metodo draw del rettangolo
        rectangle.draw();
    }
}