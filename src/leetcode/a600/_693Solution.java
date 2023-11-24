package leetcode.a600;
/**
 * 数字是否是01交替出现的数字
 * {easy}
 */
public class _693Solution {
   
    public boolean hasAlternatingBits(int n) {

        int offset = 31;
        while(((n>>offset) & 1 )==0){
            offset--;
        }
        // find left most 1
        int bit =1;
        while(offset>=0){

            if((((n>>offset) & 1 )^bit)==1){
                return false;
            }
            bit = bit^1;
            offset--;
        }
        return true;

    }

    public static void main(String[] args){
        _693Solution so = new _693Solution();
        so.hasAlternatingBits(7);
    }
}
