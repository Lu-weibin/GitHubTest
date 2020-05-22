/**
 * Created by luwb on 2020/05/22.
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = new Subject();
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
