package demo.clone;

import demo.clone.pojo.Student;
import demo.clone.pojo.Teacher;
import demo.clone.pojo.Teacher2;

/**
 * Created by luwb on 2019/12/17.
 * 测试克隆
 */
public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// 浅克隆 -> 基本数据类型与String类型都会被克隆
		method1();
		// 浅克隆 -> 克隆出来对象中引用类型成员的更改会影响到原对象
		method2();
		// 深克隆
		method3();
	}

	private static void method1() throws CloneNotSupportedException {
		Student student1 = new Student(22, "luwb");
		Student student2 = (Student) student1.clone();
		student2.setAge(23);
		student2.setName("luweibin");
		System.out.println(student1);
		System.out.println(student2);
	}

	private static void method2() throws CloneNotSupportedException {
		Student student = new Student(23, "luwb");
		Teacher teacher1 = new Teacher(40, "teacher", student);
		Teacher teacher2 = (Teacher) teacher1.clone();
		teacher2.getStudent().setName("my-Student");
		System.out.println(teacher1);
		System.out.println(teacher2);
	}

	private static void method3() throws CloneNotSupportedException {
		Student student = new Student(23, "luwb");
		Teacher2 teacher1 = new Teacher2(40, "teacher", student);
		Teacher2 teacher2 = (Teacher2) teacher1.clone();
		teacher2.getStudent().setName("my-Student ");
		System.out.println(teacher1);
		System.out.println(teacher2);
	}

}
