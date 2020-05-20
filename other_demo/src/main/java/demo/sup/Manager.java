package demo.sup;

import demo.sub.Person;

/**
 * Created by luwb on 2020/05/14.
 */
public class Manager extends Person {

    int getB() {
        return getA();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.getB();
        // student.getA(); //error
    }

}
