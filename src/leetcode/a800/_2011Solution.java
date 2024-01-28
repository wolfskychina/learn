package leetcode.a800;
/**
 * 操作之后的数值
 * {easy}
 */
public class _2011Solution {
   
    public int finalValueAfterOperations(String[] operations) {

        int count = 0;
        for(String op:operations){
            if(op.charAt(0)=='-'||op.charAt(op.length()-1)=='-')
                count--;
            else
                count++;
        }

        return count;
    }
}
