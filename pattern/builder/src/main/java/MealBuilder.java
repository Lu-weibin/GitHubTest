import pojo.*;

/**
 * Created by luwb on 2020/05/20.
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal vegMeal = builder.prepareVegMeal();
        System.out.println(vegMeal.getCost());
        vegMeal.showItems();

        Meal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println(nonVegMeal.getCost());
        nonVegMeal.showItems();
    }

}
