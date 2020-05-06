package demo.repository;

import demo.lambda.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by luwb on 2020/01/19.
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
