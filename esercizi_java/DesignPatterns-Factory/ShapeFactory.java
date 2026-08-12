//Factory che crea la forma richiesta
public class ShapeFactory {

    //Restituisce la forma corrispondente al tipo ricevuto
    public Shape getShape(ShapeType shapeType) {

        //Se il tipo è CIRCLE, crea un Circle
        if (shapeType == ShapeType.CIRCLE) {
            return new Circle();

            //Se il tipo è RECTANGLE, crea un Rectangle
        } else if (shapeType == ShapeType.RECTANGLE) {
            return new Rectangle();
        }

        return null;
    }
}