package leetcode.a1000;
/**
 * 不动点
 * 升序数组中，第一个和元素值不相等的索引
 * {binary search}
 */
public class _1064Solution {
   
    public int fixedPoint(int[] arr) {

        int l =0;
        // 这里右边界和前面大部分案例不同
        // 
        int r = arr.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]<mid)
                l=mid+1;
            else 
                r =mid;
        }

        // 如果r初始为arr.length那么这个地方需要判断l是否越界
        // 如果r初始为arr.length，即使最后l==r时仍然没有找到合适的值
        // 最后仍然会比较l==r时的情况，相当于多了一次比较
        return arr[l]==l?l:-1;
    }
}
