/**
 * Created by luwb on 2020/05/20.
 */
public class ShapeMaker {

    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }
}
