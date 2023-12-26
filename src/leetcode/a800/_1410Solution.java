package leetcode.a800;

import java.util.HashMap;
import java.util.Map;

/**
 * HTML 实体解析器
 */
public class _1410Solution {
   
    /**
     * 字符串替换
     * @param text
     * @return
     */
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>(){{
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }};
        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                while (j < n && j - i < 6 && text.charAt(j) != ';') j++;
                String sub = text.substring(i, Math.min(j + 1, n));
                if (map.containsKey(sub)) {
                    sb.append(map.get(sub));
                    i = j + 1;
                    continue;
                }
            }
            sb.append(text.charAt(i++));
        }
        return sb.toString();
    }
}
