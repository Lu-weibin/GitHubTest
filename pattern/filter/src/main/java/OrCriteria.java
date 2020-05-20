import java.util.List;

/**
 * Created by luwb on 2020/05/20.
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        List<Person> otherCriteriaPersons = otherCriteria.meetCriteria(persons);
        for (Person otherCriteriaPerson : otherCriteriaPersons) {
            if (!firstCriteriaPersons.contains(otherCriteriaPerson)) {
                firstCriteriaPersons.add(otherCriteriaPerson);
            }
        }
        return firstCriteriaPersons;
    }
}
