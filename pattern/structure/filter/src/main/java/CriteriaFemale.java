import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwb on 2020/05/20.
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("female".equalsIgnoreCase(person.getGender())) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
