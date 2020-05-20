package demo.abstractFactory;

import demo.pojo.Color;
import demo.pojo.Green;
import demo.pojo.Red;
import demo.pojo.Shape;

/**
 * Created by luwb on 2020/05/20.
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if ("red".equalsIgnoreCase(colorType)) {
            return new Red();
        } else if ("green".equalsIgnoreCase(colorType)) {
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
