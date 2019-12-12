package demo.hibernate_anno;

import demo.hibernate_anno.pojo.Hero;
import java.lang.reflect.Method;

/**
 * Created by luwb on 2019/12/12.
 * 解析注解
 */
public class ParseHibernateAnnotation {

	public static void main(String[] args) {
		Class<Hero> clazz = Hero.class;
		MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
		if (myEntity == null) {
			System.out.println("Hero类不是实体类");
		} else {
			System.out.println("Hero是实体类");
			MyTable myTable = clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("对应的表名是：" + tableName);
			Method[] methods = clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method method : methods) {
				MyId myId = method.getAnnotation(MyId.class);
				if (myId != null) {
					primaryKeyMethod = method;
					break;
				}
			}
			if (primaryKeyMethod != null) {
				System.out.println("找到主键："+ method2Attribute(primaryKeyMethod.getName()));
				MyGeneratedValue myGeneratedValue = primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("自增策略是：" + myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应数据库的字段是：" + myColumn.value());
			}
			System.out.println("其他非主键属性分别对应的数据库字段是：");
			for (Method method : methods) {
				if (method == primaryKeyMethod) {
					continue;
				}
				MyColumn myColumn = method.getAnnotation(MyColumn.class);
				if (myColumn == null) {
					continue;
				}
				System.out.format("属性：%s\t对应的数据库字段是：%s%n",method2Attribute(method.getName()),myColumn.value());
			}
		}
	}

	private static String method2Attribute(String name) {
		String result = name;
		result = result.replaceFirst("get", "");
		result = result.replaceFirst("is", "");
		if (result.length() <= 1) {
			return result.toLowerCase();
		} else {
			return result.substring(0, 1).toLowerCase() + result.substring(1, result.length());
		}
	}

}
