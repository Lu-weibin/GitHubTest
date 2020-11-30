import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwb on 2020/05/20.
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("male".equalsIgnoreCase(person.getGender())) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
