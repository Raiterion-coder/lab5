package geometry2d;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;

public class Rectangle {
    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

    private double length;
    private double width;

    public Rectangle(double length, double width) throws InvalidDimensionException {
        if (length <= 0 || width <= 0) {
            logger.log(Level.INFO, "Invalid dimensions: length={0}, width={1}", new Object[]{length, width});
            throw new InvalidDimensionException("Length and width must be positive.");
        }
        this.length = length;
        this.width = width;

        try {
            FileHandler handler = new FileHandler("figures.log", true);
            handler.setFormatter(new XMLFormatter());
            logger.addHandler(handler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create log file handler", e);
        }
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}