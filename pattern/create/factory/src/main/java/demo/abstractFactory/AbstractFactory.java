package demo.abstractFactory;

import demo.pojo.Color;
import demo.pojo.Shape;

/**
 * Created by luwb on 2020/05/20.
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shapeType);

    public abstract Color getColor(String colorType);

}
