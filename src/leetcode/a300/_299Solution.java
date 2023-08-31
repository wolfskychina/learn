package leetcode.a300;
/**
 * 两个长度相等的数字字符串
 * 比较两个字符串的相似程度，包括几个字符相同且位置相同
 * 几个字符相同但是位置不同
 */
public class _299Solution {

    /**
     * 先比较完全相同的，同时统计secret里面除去完全相同的元素信息
     * 第二趟比较统计除完全相同的外，guess里面有哪些元素在secret里面
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {

        char [] s = secret.toCharArray();
        char[] g = guess.toCharArray();

        // 关键：secret中不完全相同的元素信息
        int[] count = new int[10];
        int a =0;
        int b=0;
        for(int i=0;i<s.length;i++){
            if(s[i]==g[i]){
                a++;
            }else{
                count[s[i]-'0']++;
            }
        }
        for(int i=0;i<s.length;i++){
            if(s[i]!=g[i]&&count[g[i]-'0']!=0)
            {
                count[g[i]-'0']--;
                b++;
            }
        }

        return a+"A"+b+"B";
    }
    
}
