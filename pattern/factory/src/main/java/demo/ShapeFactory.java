package demo;

import demo.pojo.Rectangle;
import demo.pojo.Shape;
import demo.pojo.Square;

/**
 * Created by luwb on 2020/05/20.
 *
 * 工厂模式
 */
public class ShapeFactory {

        public Shape getShape(String shapeType) {
            if (shapeType == null) {
                return null;
            }
            if ("Rectangle".equalsIgnoreCase(shapeType)) {
                return new Rectangle();
            } else if ("Square".equalsIgnoreCase(shapeType)) {
                return new Square();
            }
            return null;
        }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape rectangle = factory.getShape("rectangle");
        Shape square = factory.getShape("square");
        rectangle.draw();
        square.draw();
    }

}
