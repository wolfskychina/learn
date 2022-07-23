package leetcode.array;

public class _75Solution {

    public void sortColors(int[] nums) {

        if(nums == null || nums.length == 0) return;

        int i = -1;
        int j = -1;
        int m = -1;

        for(int k = 0;k<nums.length;k++){

            switch(nums[k]){
                case 0:
                    i++;

                    nums[i] =0;

                case 1:
                    j++;

                    if(j-i != 0)
                        nums[j] =1;

                case 2:
                    m++;

                    if(m-j != 0)
                        nums[m] =2;
            }
        }
    }
}
