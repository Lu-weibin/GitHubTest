
import java.util.HashMap;

/**
 * Created by luwb on 2020/05/21.
 *
 * 享元模式（Flyweight Pattern）
 * 主要用于减少创建对象的数量，以减少内存占用和提高性能
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }

}
