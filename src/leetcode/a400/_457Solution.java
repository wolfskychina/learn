package leetcode.a400;

import java.util.HashSet;
import java.util.Set;

public class _457Solution {

    public boolean circularArrayLoop(int[] nums) {

        Set<Integer> failSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (failSet.contains(i))
                continue;
            Set<Integer> tmpSucc = new HashSet<>();
            int idx = i;
            int flag = nums[i]>0?1:-1;
            while (true) {

                if ((nums[idx] > 0 && flag>0) || 
                        (nums[idx] < 0 && flag<0)) {
                    int newidx =(idx + nums[idx]+nums.length) % nums.length;
                    if (failSet.contains(newidx)||newidx == idx) {
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

    public static void main(String[] args){

        _457Solution so = new _457Solution();
        int[] array = new int[]{-1,2,1,2};
        so.circularArrayLoop(array);
    }
}
