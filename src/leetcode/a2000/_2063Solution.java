package leetcode.a2000;

/**
 * 所有子串中包含元音字符个数的和
 * {math},{combination}
 */
public class _2063Solution {
   
    /**
     * 单独考虑每个元音字符可以出现的子串的数量
     */
    public long countVowels(String word) 
    {
        int n = word.length();
        long res = 0L;
        for(int i = 0; i < n; i ++)
        {
            if ("aeiou".contains("" + word.charAt(i)) == true)
            res += (long)(i + 1) * (n - i);
        }
        return res;
    }
}
