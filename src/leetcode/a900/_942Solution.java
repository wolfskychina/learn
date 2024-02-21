package leetcode.a900;
/**
 * 根据相邻两个数字的大小关系，生成符合条件的数字序列
 * {two pointers},{greedy}
 */
public class _942Solution {
   
    public int[] diStringMatch(String s) {

        int res[]= new int[s.length()+1];
        int i=0;
        int l=0;
        int r=s.length();
        for(char c:s.toCharArray()){

            if(c=='I'){
                res[i++]= l++;
            }else{
                res[i++]=r--;
            }
        }
        res[i] = l;
        return res;
    }
}
