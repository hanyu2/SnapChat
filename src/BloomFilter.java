import java.util.BitSet;

public class BloomFilter {
    private int defaultSize = 2 << 20;
    private int basic = defaultSize - 1;
    private BitSet bitSet;

    public BloomFilter() {
        bitSet = new BitSet(defaultSize);
    }

    // 将元素加入其中，
    public void add(String url) {
        if (url == null) {
            return;
        }
        int key1 = hashA(url);
        int key2 = hashB(url);
        int key3 = hashC(url);
        bitSet.set(key1);
        bitSet.set(key2);
        bitSet.set(key3);
    }

    // 判断一个元素是不是在其中
    public boolean contains(String url) {
        if (url == null) {
            return true;
        }
        int key1 = hashA(url);
        int key2 = hashB(url);
        int key3 = hashC(url);
        if (bitSet.get(key1) && bitSet.get(key2) && bitSet.get(key3)) {
            return true;
        }
        return false;
    }

    private int check(int speed) {
        return basic & speed;
    }

    public boolean ifNotContainsSet(String url) {
        if (url == null) {
            return true;
        }
        int key1 = hashA(url);
        int key2 = hashB(url);
        int key3 = hashC(url);
        if (bitSet.get(key1) && bitSet.get(key2) && bitSet.get(key3)) {
            return true;
        }
        bitSet.set(key1);
        bitSet.set(key2);
        bitSet.set(key3);
        return false;
    }

    private int hashA(String url) {
        int speed = 0;
        for (int i = 0; i < url.length(); i++) {
            speed = 13 * speed + url.charAt(i);
        }
        return check(speed);
    }

    private int hashB(String url) {
        int speed = 0;
        for (int i = 0; i < url.length(); i++) {
            speed = 23 * speed + url.charAt(i);
        }
        return check(speed);
    }

    private int hashC(String url) {
        int speed = 0;
        for (int i = 0; i < url.length(); i++) {
            speed = 34 * speed + url.charAt(i);
        }
        return check(speed);
    }

    public static void main(String[] args) {
        String bd = "http://www.baidu.com";
        BloomFilter bloomFilter = new BloomFilter();
        //not contains
        String tb = "http://www.taobao.com";
        System.out.println(bloomFilter.contains(tb));
        //if not contains then add
        System.out.println(bloomFilter.contains(bd));
        bloomFilter.add(bd);
        System.out.println(bloomFilter.contains(bd));
        //if not contains  then set (ifNotSet)
        String gg = "http://www.google.com";
        System.out.println(bloomFilter.ifNotContainsSet(gg));
        System.out.println(bloomFilter.contains(gg));
    }
}