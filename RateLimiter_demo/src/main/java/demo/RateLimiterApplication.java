package demo;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.io.FileUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luwb
 * @date 2020/12/02
 * <p>
 * 接口限流: 使用Guava的限流组件
 */
public class RateLimiterApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //limit();
        acquire();
    }

    private static void limit() {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //速率是每秒只有3个许可
        final RateLimiter rateLimiter = RateLimiter.create(3.0);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            Runnable runnable = () -> {
                try {
                    //获取许可
                    rateLimiter.acquire();
                    System.out.println("Accessing: " + no + ",time:"
                            + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            };
            //执行线程
            exec.execute(runnable);
        }
        //退出线程池
        exec.shutdown();
    }

    /**
     * 分布式限流: Redis + Lua
     */
    private static void acquire() throws IOException, URISyntaxException {
        Jedis jedis = new Jedis("127.0.0.1");
        File luaFile = new File(RateLimiterApplication.class.getResource("/").toURI().getPath() + "limit.lua");
        String luaScript = FileUtils.readFileToString(luaFile, StandardCharsets.UTF_8);
        // 当前秒
        String key = "ip:" + System.currentTimeMillis() / 1000;
        // 最大限制
        String limit = "5";
        List<String> keys = new ArrayList<>();
        keys.add(key);
        List<String> args = new ArrayList<>();
        args.add(limit);
        // 执行lua脚本，传入参数
        for (int i = 0; i < 10; i++) {
            Long result = (Long) (jedis.eval(luaScript, keys, args));
            System.out.println(result);
        }
    }

}
