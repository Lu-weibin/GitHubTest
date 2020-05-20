import java.util.List;

/**
 * Created by luwb on 2020/05/20.
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> persons);

}
