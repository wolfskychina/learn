package leetcode.a600;
/**
 * 图像平滑器
 */
public class _661Solution {
  
    /**
     * {matrix}
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {

        int step[][] = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
        int [][] res = new int[img.length][img[0].length];

        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){

                int sum =img[i][j];
                int count  =1;
                for(int k=0;k<step.length;k++){

                    int x = i+step[k][0];
                    int y = j+step[k][1];
                    if(x<0||x==img.length||y<0||y==img[0].length)
                        continue;
                    count++;
                    sum+=img[x][y];
                }

                res[i][j] = sum/count;
            }
        }

        return res;

    }
}
