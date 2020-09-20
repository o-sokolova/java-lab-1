package lab2_ShapesWithLogger;

public class Rectangle implements Shape{
    private final double a;
    private final double b;

    public Rectangle() {
        this(Math.random() * 10,Math.random() * 10);
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public String getShapeInfo() {
        return String.format("Rectangle with a = %2.2f; b = %2.2f", a, b);
    }
}
