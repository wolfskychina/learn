package leetcode.a2000;

/**
 * 检查数组是否连贯
 * {easy}
 */
public class _2229Solution {

    public boolean isConsecutive(int[] nums) {

        int count[] = new int[100001];
        for (int i : nums) {

            count[i]++;
        }
        int i = 0;
        while (i < count.length && count[i] == 0) {
            i++;
        }
        int j = i;
        for (; j < count.length; j++) {
            if (count[j] != 1) 
                break;
           
        }

        if (j - i == nums.length) {
            return true;
        }
        return false;

    }

    public static void main(String[] args){
        _2229Solution so = new _2229Solution();
        int[] nums ={3,5,4};
        so.isConsecutive(nums);
        
    }
}
