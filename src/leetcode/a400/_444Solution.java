package leetcode.a400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 444. Sequence Reconstruction
 * 给定一个序列num和他的若干子序列，
 * 问这些子序列的最短父序列是否一定是序列num
 */
public class _444Solution {

    /**
     * 根据基于比较的排序，n个值要确定一个唯一的顺序，至少这里面的值能够两两比较才行
     * 也就是说，至少要知道n-1对比较值才能保证唯一的顺序
     * 只需要判断子序列提供的相邻值对比中能够覆盖这n-1个对比即可
     * 但是速度比较慢
     * 
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        Set<String> set = new HashSet<String>();

        for (int i = 1; i < nums.length; i++) {

            set.add(nums[i - 1] + ":" + nums[i]);

        }

        for (List<Integer> sub : sequences) {
            int len = sub.size();
            for (int i = 1; i < len; i++) {

                set.remove(sub.get(i - 1) + ":" + sub.get(i));

            }
        }

        return set.isEmpty();
    }

    /**
     * 另外一种很快的解法，5ms
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction1(int[] nums, List<List<Integer>> sequences) {
        int n=nums.length;
        //构建一个数组 存取序列的每一位是否被访问过
        boolean[] dp=new boolean[n];
        //构建下标存取数据
        // 倒查索引
        int[] sub=new int[n+1];
        //第一个是否为真不重要 如果第二数被访问过 为真 那么他必定是被一个数访问的
        dp[0]=true;
        //存取序列下标;
        for(int i=0;i<n;i++){
            sub[nums[i]]=i;
        }
        //开始遍历子序列
        for(List<Integer> k:sequences){
            //每个子序列从1位开始 判断其数在序列的下标和其前一个数的下标是否相差为1
            //如果是的这个数在序列里面 修改为被访问过
            // 倒查在原序列中是否是相邻的
            for(int i=1;i<k.size();i++){
                if(sub[k.get(i)]-sub[k.get(i-1)]==1){
                    dp[sub[k.get(i)]]=true;
                }
            }
        }
        //遍历访问数组 只要有一个没被访问 就说明不是唯一的
        for(boolean b:dp){
            if(!b)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _444Solution so = new _444Solution();
        int[] num = { 1, 2, 3 };
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);

        so.sequenceReconstruction(num, list);
    }
}
