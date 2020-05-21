import java.util.Date;

/**
 * Created by luwb on 2020/05/21.
 *
 * 中介者模式
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }

}
