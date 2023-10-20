package leetcode.a400;

import java.util.HashSet;
import java.util.Set;

public class _457Solution {

    public boolean circularArrayLoop(int[] nums) {

        Set<Integer> failSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (failSet.contains(i))
                continue;
            // 关键，两个地方都需要取余(i + nums[i] % nums.length + nums.length) % nums.length
            if (i == (i + nums[i] % nums.length + nums.length) % nums.length)
                continue;
            Set<Integer> tmpSucc = new HashSet<>();
            int idx = (i + nums[i] % nums.length + nums.length) % nums.length;
            int flag = nums[i] > 0 ? 1 : -1;
            tmpSucc.add(i);
            while (true) {

                if ((nums[idx] > 0 && flag > 0) ||
                        (nums[idx] < 0 && flag < 0)) {
                    int newidx = (idx + nums[idx] % nums.length + nums.length) % nums.length;
                    if (failSet.contains(newidx) || idx == newidx) {
                        for (int node : tmpSucc) {
                            failSet.add(node);
                        }
                        break;
                    } else if (tmpSucc.contains(newidx)) {
                        return true;
                    } else {
                        tmpSucc.add(newidx);
                        idx = newidx;
                    }

                } else {
                    for (int node : tmpSucc) {
                        failSet.add(node);
                    }
                    break;

                }

            }

        }
        return false;

    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public boolean circularArrayLoop1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }


    public static void main(String[] args) {

        _457Solution so = new _457Solution();
        int[] array = new int[] { -2, -3, -9 };
        so.circularArrayLoop(array);
    }
}
