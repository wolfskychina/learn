package leetcode.a600;
/**
 * 离当前时刻最近的时刻
 * 要求最近的时刻中的数字由原时刻中的数字组成，但是原时刻中各个数字使用的次数不限制
 */
public class _681Solution {
   
    /**
     * 关键1：判断一个时刻是否是合法的
     * 关键2：如果当天没有最近的时刻，那么第二天最近的时刻是由原时刻中最小的数字组成的时刻
     * 关键3：原时刻中最小的数字组成的时刻一定是合法的
     * @param time
     * @return
     */
    public String nextClosestTime(String time) {
        int[] nums = new int[4]; // 使用一个长度为4的数组来记录时间，比如[1,2,3,4]代表12:34。
        char[] chars = time.toCharArray();
        int index = 0;
        // 将字符串解析成数字，并将时间放到nums数组当中
        for (int i = 0; i < chars.length; i++) {
            if (i == 2) continue;
            nums[index] = chars[i] - '0';
            index++;
        }
        // 找出nums数组当中的最小值，留作后面使用
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minNum = Math.min(minNum, nums[i]);
        }
        boolean found = false; // 使用一个变量来记录是否找到了最近时刻
        for (int i = nums.length - 1; i >= 0; i--) { // 从后向前遍历数据，因为改动后面的时间一定比改动前面的时间变动更小
            int largerNum = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) { // 使用一个循环来找到nums中比当前数字大的所有数里最小的一个，使用它来替代当前数字时间变动一定最小
                if (nums[j] > nums[i]) {
                    largerNum = Math.min(largerNum, nums[j]);
                }
            }
            if (largerNum != Integer.MAX_VALUE) {
                int temp = nums[i];
                nums[i] = largerNum;
                if (isValid(nums)) { // 判断变动之后数据是否合法，如果不合适则恢复原数据，然后继续遍历前一位
                    // 如果当前数据变动合法，那么应该从当前数据的位置继续向后遍历，将每一位赋值成nums数组当中的最小值
                    // 对应情况12:33，如果只是将时间变成13:33并不是最近时刻，因为13:11才是最近时刻
                    for (int j = i + 1; j < nums.length; j++) { 
                        nums[j] = minNum;
                    }
                    found = true;
                    break;
                }
                else nums[i] = temp;
            }
        }
        if (!found) { // 如果没有找到最近时间，那么最近时间就是第2天的最小时间，将所有值都赋值成最小值即可
            for (int i = 0; i < nums.length; i++) {
                nums[i] = minNum;
            }
        }
        StringBuilder builder = new StringBuilder();
        // 拼装最后的结果
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
            if (i == 1) builder.append(":");
        }
        return builder.toString();
    }
    
    /**
        定义一个方法用于判断时间是否有效。
        当nums[0]大于2，或者nums[0]等于2时nums[1]大于3，或者 nums[2]大于5，这三种情况下时间无效。
        其他情况下时间都是有效值。
    **/
    boolean isValid(int[] nums) {
        if (nums[0] > 2 || (nums[0] == 2 && nums[1] > 3) || nums[2] > 5) return false;
        return true;
    }    
}
