package demo;

import java.util.BitSet;

/**
 * Created by luwb on 2020/06/23.
 *
 * 布隆过滤器
 */
public class MyBloomFilter {

    /**
     * 位数组大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;
    /**
     * 通过这个数组可以创建6个不同的hash函数
     */
    private static final int[] SEEDS = {3, 13, 46, 71, 91, 134};
    /**
     * 位数组。元素只能是0和1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    /**
     * 存放包含hash函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 初始化多个包含hash函数的类的数组
     */
    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     */
    public void add(Object value) {
        for (SimpleHash hash : func) {
            bits.set(hash.hash(value), true);
        }
    }

    /**
     * 判断指定元素是否存在位数组中
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash hash : func) {
            ret = ret && bits.get(hash.hash(value));
        }
        return ret;
    }


    /**
     * 静态内部类
     * 用于hash操作
     */
    public static class SimpleHash{

        private int cap;
        private int seed;

        SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算hash值
         */
        int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

}
