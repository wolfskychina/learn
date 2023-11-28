package leetcode.a700;
/**
 * 从某个点开始渲染相同颜色的点成另外一个颜色
 * {easy}
 */
public class _733Solution {

    private static int[][] step = {{0,1},{0,-1},{1,0},{-1,0}};
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;
        int target = image[sr][sc];
  
        fill(image, sr,sc,color,target);
        
        return image;

    }

    private void fill(int[][] image, int i, int j, int color, int target) {
    
        if(i>=0&&i<image.length&&j>=0&&j<image[0].length&&image[i][j] == target){

            image[i][j] = color;
            for(int k=0;k<4;k++){

                fill(image,i+step[k][0],j+step[k][1],color,target);
            }
        }
    
    }
}
