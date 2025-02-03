package leetcode.a2000;

/**
 * 消除字符串中的相邻近似字符
 * {greedy}
 */
public class _2957Solution {
   
    public int removeAlmostEqualCharacters(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i - 1) - s.charAt(i)) <= 1) {
                ans++;
                // 这个地方是关键，一旦发生了修改就不需要再比较这个字符
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        _2957Solution so = new _2957Solution();
        String str = "acba";
        so.removeAlmostEqualCharacters(str);
    }
    
}
