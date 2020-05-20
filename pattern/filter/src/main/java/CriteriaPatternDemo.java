import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwb on 2020/05/20.
 */
public class CriteriaPatternDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        CriteriaSingle single = new CriteriaSingle();
        AndCriteria singleMale = new AndCriteria(male, single);
        OrCriteria singleOrFemale = new OrCriteria(female, single);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));
        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));
        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));
        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}