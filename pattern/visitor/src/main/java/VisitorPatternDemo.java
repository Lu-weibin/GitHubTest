/**
 * Created by luwb on 2020/05/22.
 *
 * 访问者模式
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
