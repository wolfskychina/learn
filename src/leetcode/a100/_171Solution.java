package leetcode.a100;

/**
 * 将excel中的列表编号转换为数字行号
 */
public class _171Solution {

    public int titleToNumber(String columnTitle) {

        int n = columnTitle.length();

        int re = 0;

        for (Character c : columnTitle.toCharArray()) {
            n--;
            re += (c - 'A' + 1) * Math.pow(26, n);
        }

        return re;
    }

    public static void main(String[] args) {

        _171Solution so = new _171Solution();
        System.out.println(so.titleToNumber("AB"));

    }

}
