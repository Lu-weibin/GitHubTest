package demo.optional;

import java.util.Optional;

/**
 *
 * @author luwb
 * @date 2020/04/27
 */
public class OptionalApi {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Luweibin");
        User user2 = null;

        System.out.println(testUser(user1));
        System.out.println(testUser(user2));

        System.out.println(testUserOptional(user1));
        System.out.println(testUserOptional(user2));
    }

    /**
     * 将user中属性name转换成小写
     */
    private static String testUser(User user1) {
        if (user1 != null && user1.getName() != null) {
            return user1.getName().toLowerCase();
        } else {
            return null;
        }
    }

    private static String testUserOptional(User user) {
        return Optional.ofNullable(user).map(User::getName).map(String::toLowerCase).orElse(null);
    }

}
