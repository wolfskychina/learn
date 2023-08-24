package leetcode.a200;

public class _81Solution {
   
    public boolean search(int[] nums, int target) {
      
        if (nums.length ==0) return false;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else if(nums[mid] < nums[end]){  // eg. 5,6,1,2,3,4
                // 这种情况是和普通的二分查找是一样的
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                // 这里表示nums[mid] = nums[end] 表明有冗余元素
    
                end--;
            }
        }
        if (start == end && target != nums[start]) return false;
        return true;
        }

}
