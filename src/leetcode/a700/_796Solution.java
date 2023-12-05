package leetcode.a700;
/**
 * 判断一个字符串能否通过若干次将最左侧字符移到最右侧，变成另外一个字符串
 */
public class _796Solution {
   
    /**
     * {easy},{Pigeonhole}
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String ss = s+s;
        return ss.contains(goal);

    }
}
