/**
 * Created by luwb on 2020/05/22.
 */
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}
