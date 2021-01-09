package demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.entity.User;
import demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author luwb
 * @date 2021/01/06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("list")
    public List<User> list() {
        return userMapper.selectAll();
    }

    @GetMapping("page")
    public PageInfo<User> page(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex - 1, pageSize);
        return new PageInfo<>(userMapper.selectAll());
    }

    @PostMapping("insert")
    public User insert() {
        User user = new User();
        user.setUsername("luweibin");
        user.setPassword("123456");
        userMapper.insert(user);
        return user;
    }

    @GetMapping("getById")
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @PostMapping("update")
    public int update(Integer id, String username) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUsername(username);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @GetMapping("selectByExample")
    public List<User> selectByExample(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username", username + "%");
        example.orderBy("id").asc();
        return userMapper.selectByExample(example);
    }

    @PostMapping("delete")
    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}
