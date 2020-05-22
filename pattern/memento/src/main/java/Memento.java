import lombok.Data;

/**
 * Created by luwb on 2020/05/22.
 */
@Data
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
