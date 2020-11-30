import lombok.Data;

/**
 * Created by luwb on 2020/05/22.
 *
 * 备忘录模式
 */
@Data
public class Originator {

    private String state;

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

}
