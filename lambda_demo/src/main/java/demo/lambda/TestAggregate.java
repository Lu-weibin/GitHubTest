package demo.lambda;

import demo.pojo.Hero;
import java.util.*;

/**
 * Created by luwb on 2019/12/12.
 * 聚合操作
 *
 * 管道指的是一系列的聚合操作
 * 管道又分3个部分
 *   管道源：在这个例子里，源是一个List
 *   中间操作： 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
 *   结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 *           结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,
 *           结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断
 *
 */
public class TestAggregate {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));
		}
		heros.add(heros.get(0));
		System.out.println("初始化后的集合(最后一个数据重复)：");
		System.out.println(heros);
		System.out.println("查询条件：hp>100 && damage<50");
		System.out.println("通过传统操作方式找出满足条件的数据：");
		for (Hero hero : heros) {
			if (hero.getHp() > 100 && hero.getDamage() < 50) {
				System.out.println(hero.getName());
			}
		}
		System.out.println("通过聚合操作方式找出满足条件的数据：");
		// 管道源是集合
		heros
				.stream()
				.filter(hero -> hero.getHp() > 100 && hero.getDamage() < 50)
				.forEach(hero -> System.out.println(hero.getName()));
		// 管道源是数组
		System.out.println("管道源是数组：");
		Hero[] heroes = heros.toArray(new Hero[0]);
		Arrays.stream(heroes).forEach(hero -> System.out.println(hero.getName()));
		// 中间操作
		System.out.println("去除重复的数据，去除标准是看equals");
		heros
				.stream()
				.distinct()
				.forEach(System.out::println);
		System.out.println("按照血量排序");
		heros
				.stream()
				.sorted((h1, h2) -> h1.getHp() >= h2.getHp() ? 1 : -1)
				.forEach(System.out::println);
		System.out.println("保留3个");
		heros
				.stream()
				.limit(3)
				.forEach(System.out::println);
		System.out.println("忽略前3个");
		heros
				.stream()
				.skip(3)
				.forEach(System.out::println);
		System.out.println("转换为double的Stream");
		heros
				.stream()
				.mapToDouble(Hero::getHp)
				.forEach(System.out::println);
		System.out.println("转换任意类型的Stream");
		heros
				.stream()
				.map(hero -> String.format("%s-%s-%s", hero.getName(), hero.getHp(), hero.getDamage()))
				.forEach(System.out::println);
		// 结束操作
		System.out.println("返回一个数组");
		Object[] array = heros
				.stream()
				.toArray();
		System.out.println(Arrays.toString(array));
		System.out.println("返回伤害最低的那个英雄");
		Hero minDamageHero = heros
				.stream()
//				.min((h1, h2) -> h1.getDamage() - h2.getDamage())
				.min(Comparator.comparingInt(Hero::getDamage))
				.get();
		System.out.println(minDamageHero);
		System.out.println("返回伤害最高的那个英雄");
		Hero mxnDamageHero = heros
				.stream()
				.max(Comparator.comparing(Hero::getDamage))
				.get();
		System.out.println(mxnDamageHero);
		System.out.println("流中数据的总数");
		long count = heros
				.stream()
				.count();
		System.out.println(count);
		System.out.println("第一个英雄");
		Hero firstHero = heros
				.stream()
				.findFirst()
				.get();
		System.out.println(firstHero);
	}

}
