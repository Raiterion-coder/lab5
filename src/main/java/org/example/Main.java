import java.util.logging.Logger;
import java.util.logging.Level;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.FINE);

        try {
            Circle circle = new Circle(5);
            logger.log(Level.FINE, "Circle created: {0}", circle);
            System.out.println(circle);

            Rectangle rectangle = new Rectangle(4, 6);
            logger.log(Level.FINE, "Rectangle created: {0}", rectangle);
            System.out.println(rectangle);

            Cylinder cylinder = new Cylinder(circle, 10);
            logger.log(Level.FINE, "Cylinder created: {0}", cylinder);
            System.out.println(cylinder);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred", e);
        }
    }
}