package demo.sup;

import demo.sub.Person;

/**
 * Created by luwb on 2020/05/14.
 */
public class Student extends Person {

    int getB() {
        return getA();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.getB();
//        manager.getA(); // error
    }

}
