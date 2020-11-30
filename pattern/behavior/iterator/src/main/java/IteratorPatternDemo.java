/**
 * Created by luwb on 2020/05/21.
 *
 * 迭代器模式
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            System.out.println("Name:" + name);
        }
    }

}
