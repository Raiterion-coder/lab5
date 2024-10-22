package geometry3d;

import geometry2d.Circle;
import geometry2d.InvalidDimensionException;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import geometry3d.InvalidHeightException;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cylinder {
    private static final Logger logger = Logger.getLogger(Cylinder.class.getName());

    private Circle base;
    private double height;

    public Cylinder(Circle base, double height) throws InvalidHeightException {
        if (height <= 0) {
            logger.log(Level.FINEST, "Invalid height: {0}", height);
            throw new InvalidHeightException("Height must be positive.");
        }
        this.base = base;
        this.height = height;

        try {
            FileHandler handler = new FileHandler("cylinder.log", true);
            handler.setFormatter(new java.util.logging.SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$s] %3$s %n";

                @Override
                public synchronized String format(java.util.logging.LogRecord lr) {
                    return String.format(format,
                            new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            });
            logger.addHandler(handler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create log file handler", e);
        }
    }

    public double volume() {
        return base.area() * height;
    }
}