package leetcode.a300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 356. Line Reflection
 * 给定的点是不是关于Y轴对称的
 * 可能有重复的点
 */
public class _356Solution {
   
    public boolean isReflected(int[][] points) {
        //1.首先，遍历数组找到最左和最右的点，以此确定x
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<points.length;i++){
            int j = points[i][0];
            max=Math.max(j,max);
            min=Math.min(j,min);
        }

        double x = (max+min)/2.0d;

        //2.确定了预期的x后，用HashSet<List<Integer>存储点所有的点，遍历Set中的所有List是否存在镜像点
        // Set区分List类型的唯一性
        // Set先使用对象的hashcode进行相等比较
        // List直接调用元素对象Integer的hashCode方法，逐项计算
        // Integer的hashCode就是元素的整数值
        // 如果一个List<Integer>里面Integer的大小，顺序都一样
        // 那么List<Integer>的hashcode计算出来的都一样
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<points.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(points[i][0]);
            list.add(points[i][1]);
            set.add(list);
        }
        //遍历集合
        for(List<Integer> list:set){
            List<Integer> temp = new ArrayList<>();
            temp.add((int)(2*x)-list.get(0));
            temp.add(list.get(1));
            if(!set.contains(temp)){
                return false;
            } 
        }
        return true;
    }
}
