package leetcode.a700;
/**
 * 在LR字符串中交换字符，L左侧有X时可以和左侧的X互换
 * R右侧有X时可以和右侧的X互换，问start能否通过位置变换成为end
 * 
 */
public class _777Solution {
   
    /**
     * {two poiters}LR可以分别向左右移动，但是不能翻越其他的LR
     * 也就是说start和end中LR的相对顺序是一致的，如果不一致说明无法变化
     * TODO
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) return i == j;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++; j++;
        }
        return i == j;
    }

}
