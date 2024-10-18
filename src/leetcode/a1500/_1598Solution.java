package leetcode.a1500;
/**
 * 需要多少次才能返回到原目录
 * {easy}
 */
public class _1598Solution {
   
    public int minOperations(String[] logs) {

        int count =0;
        for(String str:logs){

            if(str.equals("./")){
                continue;
            }else if(str.equals("../")){
                if(count>0) count--;
            }else{
                count++;
            }
        }
        return count;
    }
}
