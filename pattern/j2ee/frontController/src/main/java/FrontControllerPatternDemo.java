/**
 * Created by luwb on 2020/05/22.
 */
public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("home");
        System.out.println();
        frontController.dispatchRequest("student");
    }
}
