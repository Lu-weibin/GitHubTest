import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by luwb on 2020/05/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

}
