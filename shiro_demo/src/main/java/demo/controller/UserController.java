package demo.controller;

import demo.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author luwb
 * @date 2019-12-07
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("{id}")
    public User getUser(@PathVariable Integer id) {
        return new User(id, "luwb", "123456", new Date(), "1");
    }

}
