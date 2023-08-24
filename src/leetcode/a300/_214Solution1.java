package leetcode.a300;

/**
 * 一个字符串，最少在前面补充多少个字符可以变成回文串
 * 输出这个最短的回文串
 * 开始看错题了，以为前后补充字符都可以
 */
public class _214Solution1 {
   
    public String shortestPalindrome1(String s) {

        if(s==null || s.equals("")) return s;
        int min = Integer.MAX_VALUE;
        char[] word = s.toCharArray();
        // 对每个字母循环
        for(int i =0 ;i< word.length; i++) {
        // 判断以某一个字符为中心是否能够补全成为回文串
        // 回文串需要判断两次，分别是以字符为中心和以当前两个字符为中心进行判断
        int len1 = ifPalindrome(word, i,i);
        int len2 = ifPalindrome(word, i, i+1);

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
        String re = sb.toString();
        if(isPalindrome(re)) return re;

        sb = new StringBuilder();
        sb.append(s);

        for(int i=min-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        re = sb.toString();

        return re;

    }

    private boolean isPalindrome(String word){

        char[] array = word.toCharArray();
        for(int i =0;i<array.length/2;i++){
            if(array[i] != array[array.length -i-1])
                return false;
        }

        return true;
    }

    private int ifPalindrome(char[] word, int l, int r){
            boolean odd ;
            if(l==r){
                odd = true;
            }else{
                odd = false;
            }
            int count = 0;

            while(l>=0 && r<word.length){


                if(word[l] != word[r]) return -1;
                count++;
                l--;
                r++;
            }

            if(l == -1 && r == word.length) return 0;

            if(odd){
                return word.length - 2*count +1;
            }else{
                return word.length - 2*count;
            }

    }

    public static void main(String[] args){

        _214Solution1 so = new _214Solution1();
        System.out.println(so.shortestPalindrome1("ba"));
    }
}
