package leetcode.a100;

/**
 * 反转单词词组，要求不使用额外空间
 */
public class _186Solution {
   
    public void reverseWords(char[] s) {
       
        reverse(s, 0, s.length);

        int i =0;
        int j =0;
        for(;j<s.length;j++){
            if(s[j]!=' ') continue;
            reverse(s, i, j);
            i = j+1;
        }
        reverse(s,i,s.length);
        
    }

    private void reverse(char[] s, int i, int j) {
        char tmp;
        while(i<j-1){
            tmp =s[i];
            s[i] = s[j-1];
            s[j-1] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
       _186Solution so = new _186Solution();
       char [] a = "test".toCharArray();
       so.reverseWords(a);
       System.out.println(a); 
    }
}
