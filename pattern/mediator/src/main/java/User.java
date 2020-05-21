import lombok.Data;

/**
 * Created by luwb on 2020/05/21.
 */
@Data
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }

    public static void main(String[] args) {
        User robert = new User("Robert");
        User user = new User("John");

        robert.sendMessage("Hi robert!");
        user.sendMessage("Hello John!");
    }

}
