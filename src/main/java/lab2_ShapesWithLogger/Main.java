package lab2_ShapesWithLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        List<Double> perimeters = new ArrayList<>();

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = getRandomShape();
            perimeters.add(shapes[i].getPerimeter());
            logger.info(shapes[i].getShapeInfo() + " has perimeter = " + perimeters.get(i));
        }
        int indexOfShapeWithMinPerimeter = perimeters.indexOf(Collections.min(perimeters));
        int indexOfShapeWithMaxPerimeter = perimeters.indexOf(Collections.max(perimeters));
        logger.info("Min perimeter: " + perimeters.get(indexOfShapeWithMinPerimeter) + ":  " +
                shapes[indexOfShapeWithMinPerimeter].getShapeInfo());
        logger.info("Max perimeter: " + perimeters.get(indexOfShapeWithMaxPerimeter) + ":  " +
                shapes[indexOfShapeWithMaxPerimeter].getShapeInfo());

        logger.error("I'm error");
        logger.debug("You don't see me");
        logger.warn("I'm warn");
    }

    static Shape getRandomShape(){
        int shapeIndex = (int)Math.floor(Math.random() * 3);
        switch (shapeIndex){
            case 0: {
                return new Rectangle();
            }
            case 1: {
                return new Triangle();
            }
            default: {
                return new Circle();
            }
        }
    }
}
