package leetcode.a600;
/**
 * 判断一个整数数组，能够通过只修改其中的一个数字，使得
 * 数组变成非递减序列？
 */
public class _665Solution {
   
    /**
     * 可能存在不止一个逆序对的情况
     * 如果超过一个逆序对，那么只修改一个数字肯定不行
     * 如果只有一个逆序对，那么修改这一对中的任意一个数字都可能
     * 所以需要分别判断。例如abcd四个数字中，bc是逆序对 a(b,c)d 
     * 需要把b缩小或者c放大，为了尽可能满足条件，b最小可以为a，c最大可以为d
     * 所以只要比较a和c，b和d的大小，即可知道修改bc中一个的值能否满足条件
     * 
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {

        if(nums.length==1||nums.length==2) return true;

        int i=0;
        int revNum = 0;
        int idx = 0;
        for(;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                revNum ++;
                idx =i;
            }
                
        }
        if(revNum ==0) return true;
        if(revNum>1) return false;
        
        if(idx==0||idx+1== nums.length-1||nums[idx-1]<=nums[idx+1]||nums[idx]<=nums[idx+2]) return true;

        return false;


    }  
    public static void main(String[] args){

        _665Solution so = new _665Solution();
        int array [] = {1,2,3};
        so.checkPossibility(array);
    } 
}
