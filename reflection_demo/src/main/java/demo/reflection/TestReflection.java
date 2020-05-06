package demo.reflection;

import demo.lambda.pojo.Hero;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by luwb on 2019/12/12.
 * TestReflection
 */
public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// 反射获取类对象
		method1();
		// 通过反射的方式创建对象
		method2();
		// 通过反射获取类的属性
		method3();
		// 通过反射获取方法
		method4();

	}

	private static void method1() throws ClassNotFoundException {
		String className = "demo.lambda.pojo.Hero";
		Class aClass1 = Class.forName(className);
		Class<Hero> aClass2 = Hero.class;
		Class aClass3 = new Hero().getClass();
		// true
		System.out.println(aClass1 == aClass2);
		// true
		System.out.println(aClass2 == aClass3);
	}

	private static void method2() {
		// 使用传统方式创建对象
		Hero hero1 = new Hero();
//		hero1.name = "teemo";
		System.out.println(hero1);
		// 使用反射方式创建对象
		try {
			String className = "demo.lambda.pojo.Hero";
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor();
			Hero hero2 = (Hero) constructor.newInstance();
			System.out.println(hero2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void method3() throws NoSuchFieldException, IllegalAccessException {
		Hero hero = new Hero();
		hero.setName("luwb");
		Field name = hero.getClass().getDeclaredField("name");
		// 访问private属性时需要
		name.setAccessible(true);
		name.set(hero,"luwwbb");
		System.out.println(hero.getName());
	}

	private static void method4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Hero hero = new Hero();
		// 方法名为setName, 参数类型为String
		Method setName = hero.getClass().getMethod("setName",String.class);
		setName.invoke(hero, "hahah");
		System.out.println(hero.getName());
	}

}
