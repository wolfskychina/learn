package leetcode.a200;

/**
 * 一个字符串，最少在前面补充多少个字符可以变成回文串
 * 输出这个最短的回文串
 * on2的解法，超时了
 */
public class _214Solution {
   
    public String shortestPalindrome(String s) {

        if(s==null || s.equals("")) return s;
        int min = Integer.MAX_VALUE;
        char[] word = s.toCharArray();
        // 对每个字母循环
        // word.length -1 /2 保证是在左边补充字符
        for(int i =0 ;i<= (word.length-1)/2; i++) {
        // 判断以某一个字符为中心是否能够补全成为回文串
        // 回文串需要判断两次，分别是以字符为中心和以当前两个字符为中心进行判断
        int len1 = ifPalindrome(word, i,i);
        int len2 = ifPalindrome(word, i-1, i);

        // 如果能够补全，则计算需要补全的长度，和当前最小值比较
        if(len1>=0) min = Math.min(min,len1);
        if(len2>=0) min = Math.min(min,len2);
        }

        // System.out.println("the min is:"+min);

        // 结束循环，返回当前最小值
        return restorePalindrome(s, min);

    }

    private String restorePalindrome(String s, int min){
        StringBuilder sb =new StringBuilder();
        int length = s.length();
        for(int i=0;i<min;i++){
            sb.append(s.charAt(length-1-i));
        }
        sb.append(s);
        return sb.toString();

    }

    private int ifPalindrome(char[] word, int l, int r){
            boolean odd ;
            odd = l == r;
            int count = 0;

            while(l>=0 && r<word.length){

                if(word[l] != word[r]) return -1;
                count++;
                l--;
                r++;
            }

            if(odd){
                return word.length - 2*count +1;
            }else{
                return word.length - 2*count;
            }

    }

    public static void main(String[] args){

        _214Solution so = new _214Solution();
        System.out.println(so.shortestPalindrome("abb"));
    }
}
