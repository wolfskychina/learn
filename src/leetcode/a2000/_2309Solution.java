package leetcode.a2000;
/**
 * 兼具大小写字母的最大英文字母
 */
public class _2309Solution {
   
    public String greatestLetter(String s) {
        int count[] = new int['z'-'A'+1];
        for(char c:s.toCharArray()){
            count[c-'A']++;
        }
        for(int i=25;i>=0;i--){
            if(count[i]>0&&count[i+'a'-'A']>0)
                return String.valueOf((char)('A'+i));
        }

        return "";
    }

    public String greatestLetter1(String s) {
        char lc = 'z';
        char hc = 'Z';
        for (int i = 0; i < 26; i++) {
            if (s.indexOf(lc) != -1 && s.indexOf(hc) != -1) {
                return String.valueOf(hc);
            }
            lc--;
            hc--;
        }
        return "";

    }
}
