package geometry;

class Circle {
    public static final double PI =  3.14; //constant PI which can be accessed outside the class Circle.PI
    //static variable- shared amongst all the instances of the class
    private static int numberOfInstances;
    private double radius;

    Circle() {
        numberOfInstances ++;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius ( double newRadius ){
        radius = newRadius;
    }
    static int getNumberOfInstances(){
        return numberOfInstances;
    }
    static void printNumberOfInstances(){
        System.out.println("\nNumber of circle instances created so far :: "+ numberOfInstances);

    }
    public double getArea() {
        return Circle.PI * radius * radius;
    }
}
