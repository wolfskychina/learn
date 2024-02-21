package leetcode.a1000;
/**
 * 两个字符串的最大公因子
 */
public class _1071Solution {
   
    /**
     * 实际上是两个字符串长度的最大公因子长度的子串能够重复构成两个串
     * 如果不能，那么两个字符串的gcd子串一定是空的
     * {gcd}
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {

        if(str1.equals(str2)) return str1;

        int len1 = str1.length();
        int len2 = str2.length();

        int gcd = gcd(len1,len2);
        String tar = str1.substring(0,gcd);

        for(int i=gcd;i<len1;i+=gcd){
            if(!tar.equals(str1.substring(i,i+gcd))){
                return "";
            }
        }
        for(int i=gcd;i<len2;i+=gcd){
            if(!tar.equals(str2.substring(i,i+gcd))){
                return "";
            }
        }
        return tar;


    }

    private int gcd(int len1, int len2) {
        if(len1<len2){
            int tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        while(len1%len2!=0){
            int newlen2 = len1%len2;
            len1 = len2;
            len2 = newlen2;
        }
        return len2;
    }
}
