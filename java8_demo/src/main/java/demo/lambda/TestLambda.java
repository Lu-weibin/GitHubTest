package demo.lambda;

import demo.lambda.pojo.Hero;

import java.util.*;

/**
 * Created by luwb on 2019/12/12.
 * TestLambda
 */
public class TestLambda {

	public static void main(String[] args) {
		Random random = new Random();
		List<Hero> heroes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			heroes.add(new Hero("hero" + i, random.nextInt(1000), random.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heroes);
		System.out.println("筛选hp>100 && damage<50的英雄：");
		filter(heroes);
		System.out.println("使用匿名类的方式，筛选hp>100 && damage<50的英雄：");
		HeroChecker checker = new HeroChecker() {
			@Override
			public boolean test(Hero hero) {
				return hero.getHp() > 100 && hero.getDamage() < 50;
			}
		};
		filter(heroes,checker);
		System.out.println(" 使用Lambda的方式，筛选hp>100 && damage<50的英雄：");
		filter(heroes, (hero) -> hero.getHp() > 100 && hero.getDamage() < 50);

		// map集合
		Map<String, String> map = new HashMap<>();
		map.put("ha1", "string1");
		map.forEach((key,value)-> System.out.printf("key:%s value:%s",key,value));
	}

	private static void filter(List<Hero> heroes) {
		for (Hero hero : heroes) {
			if (hero.getHp() > 100 && hero.getDamage() < 50) {
				System.out.println(hero);
			}
		}
	}

	private static void filter(List<Hero> heroes, HeroChecker checker) {
		for (Hero hero : heroes) {
			if (checker.test(hero)) {
				System.out.println(hero);
			}
		}
	}

}
