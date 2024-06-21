package leetcode.a500;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 设计短链接发生器
 * {random},{hashmap},{design}
 */
public class _535Solution {

    public class Codec {
        Map<String, String> origin2Tiny = new HashMap<>(), tiny2Origin = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String prefix = "https://acoier.com/tags/";
        int k = 6;
        Random random = new Random();

        public String encode(String longUrl) {
            while (!origin2Tiny.containsKey(longUrl)) {
                char[] cs = new char[k];
                for (int i = 0; i < k; i++)
                    cs[i] = str.charAt(random.nextInt(str.length()));
                String cur = prefix + String.valueOf(cs);
                if (tiny2Origin.containsKey(cur))
                    continue;
                tiny2Origin.put(cur, longUrl);
                origin2Tiny.put(longUrl, cur);
            }
            return origin2Tiny.get(longUrl);
        }

        public String decode(String shortUrl) {
            return tiny2Origin.get(shortUrl);
        }
    }

}
