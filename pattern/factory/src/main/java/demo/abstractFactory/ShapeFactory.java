package demo.abstractFactory;

import demo.pojo.Color;
import demo.pojo.Rectangle;
import demo.pojo.Shape;
import demo.pojo.Square;

/**
 * Created by luwb on 2020/05/20.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
