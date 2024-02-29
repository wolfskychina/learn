package leetcode.a0;
/**
 * 柱状图中的连续的最大矩形
 */
public class _84Solution {

    public static int largestRectangleArea(int[] height){

        if(height== null|| height.length==0) return 0;

        int[] lessFromLeft = new int[height.length];
        int[] lessFromRight = new int[height.length];

        lessFromRight[height.length-1] = height.length;
        lessFromLeft[0] = -1;

        // form the lessFromLeft
        for(int i=1; i<height.length;i++){

            int p=i-1;
            while(p>=0 && height[p] >= height[i]){
                p = lessFromLeft[p];
            }

            lessFromLeft[i] = p;
        }

        // form the lessFromRight
        for(int i=height.length-1; i>=0;i--){
            int p=i+1;

            while(p<height.length&&height[p]>=height[i]){
                p = lessFromRight[p];
            }

            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for(int i=0;i<height.length;i++){
            maxArea = Math.max(maxArea, height[i]*(lessFromRight[i]-lessFromLeft[i]-1));
        }

        return maxArea;
    }
}
