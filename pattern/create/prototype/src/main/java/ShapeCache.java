import pojo.Rectangle;
import pojo.Shape;
import pojo.Square;
import java.util.Hashtable;

/**
 * Created by luwb on 2020/05/20.
 *
 * 原型模式
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cacheShape = shapeMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    /**
     * 模拟从数据库读取数据
     */
    public static void loadCache() {
        Square square = new Square();
        square.setId("1");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeMap.put(rectangle.getId(), rectangle);
    }

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
    }

}
