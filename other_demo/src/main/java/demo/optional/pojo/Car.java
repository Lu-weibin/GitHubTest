package demo.optional.pojo;

import lombok.Data;
import java.util.Optional;

/**
 * Created by luwb on 2019/12/26.
 */
@Data
public class Car {

	private Optional<Insurance> insurance;

}
