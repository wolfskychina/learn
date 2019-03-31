package leetcode.array;

/**
 * trap water problem
 */
public class _42Solution {

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int left = 1;
        int right = height.length - 2;
        int max = 0;
        int tmp = 0;
        int sum = 0;
        int sum2 = 0;
        int lefttop = 0;
        int righttop = 0;
        //find max num
        for (int i = 0; i < height.length; i++) {
            sum2 += height[i];
            if (height[i] > max) {
                max = height[i];
                lefttop = i;
            }
        }
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] == max) {
                righttop = i;
                break;
            }
        }

        sum = max - height[0] + max - height[height.length - 1];

        tmp = 0;
        while (left < lefttop) {

            if (height[left] > height[tmp]) {
                tmp = left;
            }
            sum += max - height[tmp];
            // System.out.println("max-tmp is:"+(max-height[tmp]));
            left++;
        }

        tmp = height.length - 1;
        while (right > righttop) {
            if (height[right] > height[tmp]) {
                tmp = right;
            }
            sum += max - height[tmp];
            right--;
        }


        return max * height.length - sum - sum2;
    }
}
