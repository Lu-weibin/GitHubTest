package demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 *
 * @author luwb
 * @date 2020/06/23
 */
public class BloomFilterTest {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) {

        // 使用自已实现的布隆过滤器
        MyBloomFilter filter = new MyBloomFilter();
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

        Integer value3 = 13423;
        Integer value4 = 22131;
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));
        filter.add(value3);
        filter.add(value4);
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));

        // 利用Google开源的 Guava中自带的布隆过滤器
        System.out.println("\n利用Google开源的 Guava中自带的布隆过滤器");
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1500, 0.01);
        System.out.println(bloomFilter.mightContain(value3));
        System.out.println(bloomFilter.mightContain(value4));
        bloomFilter.put(value3);
        bloomFilter.put(value4);
        System.out.println(bloomFilter.mightContain(value3));
        System.out.println(bloomFilter.mightContain(value4));
    }

}
