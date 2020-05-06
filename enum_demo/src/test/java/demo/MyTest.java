package demo;

import demo.pojo.Pizza;
import org.junit.Test;

/**
 * Created by luwb on 2020/04/27.
 */
public class MyTest {

    @Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());
    }

}
