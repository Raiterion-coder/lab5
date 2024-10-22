package geometry2d;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;

public class Circle {
    private static final Logger logger = Logger.getLogger(Circle.class.getName());

    private double radius;

    public Circle(double radius) throws InvalidDimensionException {
        if (radius <= 0) {
            logger.log(Level.SEVERE, "Invalid radius: {0}", radius);
            throw new InvalidDimensionException("Radius must be positive.");
        }
        this.radius = radius;

        try {
            FileHandler handler = new FileHandler("figures.log", true);
            handler.setFormatter(new XMLFormatter());
            logger.addHandler(handler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create log file handler", e);
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}