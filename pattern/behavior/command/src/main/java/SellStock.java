/**
 * Created by luwb on 2020/05/21.
 */

public class SellStock implements Order {

    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}

