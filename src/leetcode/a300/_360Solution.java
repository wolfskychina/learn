package leetcode.a300;

public class _360Solution {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        if (a == 0) {

            for(int j=0;j<nums.length;j++){
                nums[j] = b*nums[j]+c;
            }

            if (b >= 0) {
                return nums;
            } else {
                for (int i = 0; i < nums.length/2; i++) {
                    int tmp = nums[i];
                    nums[i] = nums[nums.length - 1 - i];
                    nums[nums.length - 1 - i] = tmp;
                }
                return nums;

            }
        }

        // 抛物线
        double axis = -(b / 2D / a);
        int i = 0;
        while(i < nums.length) {
            if (nums[i] < axis) {
                i++;
            }else{
                break;
            }
        }

        // 有两段，以i为右边的起点，进行归并
        int l = 0;
        int r = i;
        int[] res = new int[nums.length];
        int k = 0;

        if(a<0){
            // 反转后半段
            // 反转的时候，下标不从0开始，容易写错
            // TODO
            for(int j =i;j<=(i+nums.length-1)/2;j++){
                int tmp = nums[j];
                nums[j] = nums[nums.length-1-j+i];
                nums[nums.length-1-j+i] = tmp;
            }

        }else{
            // 反转前半段
            for(int j=0;j<i/2;j++){
                int tmp = nums[j];
                nums[j] = nums[i-1-j];
                nums[i-1-j]=tmp;
            }
        }
        // 两边的fx函数值都是递增的
        while (r < nums.length && l <i) {

            int y1 = a * nums[l] * nums[l] + b * nums[l] + c;
            int y2 = a * nums[r] * nums[r] + b * nums[r] + c;
            if (y1 <= y2) {
                res[k] = y1;
                l++;
            } else {
                res[k] = y2;
                r++;
            }
            k++;
        }

        while (l <i) {
            res[k] = a * nums[l] * nums[l] + b * nums[l] + c;
            l++;
            k++;
        }

        while (r < nums.length) {
            res[k] = a * nums[r] * nums[r] + b * nums[r] + c;
            r++;
            k++;
        }

        return res;

    }

    public static void main(String[] args){
        _360Solution so = new _360Solution();
        int [] ans = {-99,-94,-90,-88,-84,-83,-79,-68,-58,-52,-52,-50,-47,-45,-35,-29,-5,-1,9,12,13,25,27,33,36,38,40,46,47,49,57,57,61,63,73,75,79,97,98};
        so.sortTransformedArray(ans, -2, 44, -56);

    }
}
