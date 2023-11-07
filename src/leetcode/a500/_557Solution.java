package leetcode.a500;
/**
 * 对句子中的每个单词内部字母进行反转
 */
public class _557Solution {
   
    public String reverseWords(String s) {

        char[] res = s.toCharArray();

        int i=0;
        int j=0;
        while(j<res.length){

            while(j<res.length && res[j]!=' ')
                  j++;
            reverse(res, i,j-1);
            j++;
            i=j;
        }

        return String.valueOf(res);

    }

    private void reverse(char[] res, int i, int j){

        while(i<j){
            char tmp = res[i];
            res[i] = res[j];
            res[j] =tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){

        _557Solution so = new _557Solution();
        so.reverseWords("Let's take LeetCode contest");
    }
}
