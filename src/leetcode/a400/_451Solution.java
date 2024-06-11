package leetcode.a400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将字符串按照字母出现的频率进行排序输出
 * {bucket sort}
 */
public class _451Solution {
   
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Character> [] bucket = new List [s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort1(String s) {

        int[] list = new int[123];//hash表
        char[] chars = s.toCharArray();//获取字符数组
        for (int i = 0; i < chars.length; i++) {//统计每个字符出现的次数
            int n = (int) chars[i];//获取当前字符的ASCII码
            list[n]++;//对应hash位置+1
        }
        int index = 0;//结果字符数组的下标
        while (index < chars.length) {
            int max = 0;//保存最大值
            char target = ' ';//保存出现次数最多的字符
            for (int i = 48; i < list.length; i++) {//遍历hash表
                if (list[i] > max) {//如果当前字符出现次数更多
                    max = list[i];//保存这个次数
                    target = (char) i ;//让target指向这个字符
                }
            }
            for (int j = 0; j < max; j++) {//将其拼接到字符数组中
                chars[index++] = target;
            }
            list[target] = 0;//hash表中已经输出的字符归0
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args){

        _451Solution so = new _451Solution();
        System.out.println(so.frequencySort("asdfk;adsfnbebrelivucvnbdkf"));

    }
}
