package geometry;

public class TestCircle {
    public static void main(String[] args){

        Circle.printNumberOfInstances();

        Circle circle1 = new Circle();
        printArea( circle1 );
        Circle.printNumberOfInstances();

        Circle circle2= new Circle( );
        circle2.setRadius( 20 );
        printArea( circle2 );
        Circle.printNumberOfInstances();

        Circle circle3 = new Circle();
        circle3.setRadius( 30 );
        printArea( circle3 );
        Circle.printNumberOfInstances();
    }

    private static void printArea(Circle circle1) {
        System.out.printf("\nRadius is:: %.2f,  Area of circle is:: %.2f \n", (double) circle1.getRadius(), circle1.getArea());
    }

}
