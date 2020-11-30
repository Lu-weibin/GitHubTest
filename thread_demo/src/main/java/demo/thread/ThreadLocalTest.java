package demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luwb
 * @date 2020/06/29
 */
public class ThreadLocalTest {

    private List<String> messages = new ArrayList<>();

    private static ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.get().messages.clear();
        return messages;
    }

}
