package leetcode.a0;

import java.util.ArrayList;
import java.util.List;
/**
 * 往一个不重合的区间集合中插入一个新的闭区间
 * 返回合并后的新的区间集合
 */
public class _57Solution {
  
    public int[][] insert(int[][] intervals, int[] newInterval){

        int start = newInterval[0];
        int end = newInterval[1];
        // start,end是未被加入到最终集合中的临时区间
        List<int[]> list = new ArrayList<>();

        // 核心是从头开始将所有的区间重新插入
        for(int[] interval:intervals){

            int curStart = interval[0];
            int curEnd = interval[1];

            // start 和 end 是一直向后遍历的指针
            if(curEnd<start){
                list.add(new int[]{curStart, curEnd});
            }else if(curStart>end){
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
                // {curStart, curEnd} 这次没有加入list，下次需要比较
            }else{
                // 存在重叠的情况
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
                // 先融合成一个新的区间，但是暂时不加到list中

            }
        }

        // start和end是一直向后移动的，最后一组在循环中没有加到最终结果
        list.add(new int[]{start, end});
        return list.toArray(new int[intervals.length][2]);
    }
}
