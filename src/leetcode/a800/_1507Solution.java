package leetcode.a800;

import java.util.HashMap;
import java.util.Map;
/**
 * 转变日期格式
 * {easy}
 */
public class _1507Solution {

    private Map<String, String> map;

    public String reformatDate(String date) {
        map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        String[] deformat = date.split(" ");
        deformat[1] = map.get(deformat[1]);
        deformat[0] = mapday(deformat[0]);
        StringBuilder sb = new StringBuilder();
        return sb.append(deformat[2]).append("-").append(deformat[1]).append("-").append(deformat[0]).toString();

    }

    private String mapday(String str) {
        if (str.length() == 3) {
            return "0" + str.substring(0, 1);
        } else {
            return str.substring(0, 2);
        }
    }
}
