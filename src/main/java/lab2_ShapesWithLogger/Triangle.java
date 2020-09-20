package lab2_ShapesWithLogger;

public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle() {
        this(Math.random() * 10, Math.random() * 10, Math.random() * 10);
    }
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String getShapeInfo() {
        return String.format("Triangle with a = %2.2f; b = %2.2f; c = %2.2f", a, b, c);
    }
}
