package leetcode.a1800;

import java.util.HashSet;
import java.util.Set;
/**
 * 字符串中不同整数的数目
 * 字符串转整数可能会越界
 */
public class _1805Solution {
   
    public int numDifferentIntegers(String word) {

        char[] arr = word.toCharArray();

        int i = 0;
        Set<String> set = new HashSet<>();

        while (i < arr.length) {

            while (i < arr.length && (arr[i] < '0' || arr[i] > '9')) {
                i++;
            }
            if (i == arr.length)
                break;
            StringBuilder sb = new StringBuilder();
            Boolean start0 = true;
            while (i < arr.length && (arr[i] >= '0' && arr[i] <= '9')) {
                if (arr[i] == '0' && start0) {
                    i++;
                    continue;
                }
                start0 = false;
                sb.append(arr[i]);
                i++;
            }
            if (sb.length() == 0)
                sb.append('0');

            set.add(sb.toString());
        }
        return set.size();
    }
}
