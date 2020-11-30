package demo.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author luwb
 * @date 2020/11/16
 */
public class TestFunction {

    /**
     * Function: 一个入参，一个返回值
     * Consumer: 一个入参，无返回值
     * Supplier: 无入参，有返回值
     * Predicate: 一个入参，返回Boolean
     * UnaryOperator: 入参和返回值的类型相同（特殊类的Function）
     * 剩下的是两个参数的接口
     */
    public static void main(String[] args) {
        Consumer<String> tConsumer = System.out::println;
        tConsumer.accept("java");

        Supplier<String> supplier = () -> "java";
        String str = supplier.get();
        System.out.println(str);

    }

}
