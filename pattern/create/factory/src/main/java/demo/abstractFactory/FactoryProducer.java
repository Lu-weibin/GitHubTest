package demo.abstractFactory;

import demo.pojo.Color;
import demo.pojo.Shape;

/**
 * Created by luwb on 2020/05/20.
 *
 * 抽象工厂
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if ("shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape square = shapeFactory.getShape("square");
        Shape rectangle = shapeFactory.getShape("rectangle");
        square.draw();
        rectangle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        Color green = colorFactory.getColor("green");
        red.fill();
        green.fill();
    }

}
