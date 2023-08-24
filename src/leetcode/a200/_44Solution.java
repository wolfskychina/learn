package leetcode.a200;

public class _44Solution {

    public boolean isMatch(String s, String p){
        int i = 0, j =0, iStar = -1, jStar = -1,m = s.length(), n = p.length();
        while(i<m){
            if(j<n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                // 1
                i++;
                j++;
                // 此处的ij不一定是永久跳过，可能在3步中发生回退
            }else if( j<n && p.charAt(j)=='*'){
                // 2
                iStar = i;
                jStar = j++;
                // j是×号的情况，i不变，j往后移一位
            }else if(iStar >= 0) {
                // 3
                i = ++iStar;
                j = jStar +1;
                // 发生了i和j不匹配的情况，但是iStar不是负值
                // 说明有一个有效的*可以吃掉这个不匹配
                // i,j都移动到iStar和jStar后面的一个位置，i和istar增大表示跳过，但是jStar是不变的
                // 也就是说如果匹配不上，就总是和jstar后面的这个字符比较
                // 分支3的上一步可能是分支23，也可能是1
                // 如果是分支2.3说明一直没有匹配上
                // 如果是分支1，说明中间有几个匹配上了，但是这个没有匹配上
            }else return false;
        }

        while(j<n && p.charAt(j) == '*') ++j;
        return  j==n;
    }

    public static void main(String[] args){
        _44Solution so = new _44Solution();
        so.isMatch("eradbckts","er*cks");
    }
}
