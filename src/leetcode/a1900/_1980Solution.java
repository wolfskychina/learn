package leetcode.a1900;

/**
 * 找到一个与给定数组中所有二进制字符串都不同的新二进制字符串。
 * 数组中每个字符串的长度都为 n，且只包含字符 '0' 和 '1'。
 * 数组的大小也是n
 * 要求返回的新字符串也必须是二进制字符串，且长度也为 n。
    {brain teaser}
 */
public class _1980Solution {
   
    public String findDifferentBinaryString(String[] nums) {
        // 康托对角线法：第 i 位取 nums[i] 第 i 位的翻转值，保证与所有字符串不同
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            // 翻转第 i 个字符串的第 i 位：'0'→'1', '1'→'0'
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

}
