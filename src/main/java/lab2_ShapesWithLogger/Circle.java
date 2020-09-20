package lab2_ShapesWithLogger;

public class Circle implements Shape {
    private final double r;

    public Circle() {
        this(Math.random() * 10);
    }
    
    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public String getShapeInfo() {
        return String.format("Circle with r = %2.2f", r);
    }
}
