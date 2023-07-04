package leetcode.array;

public class _58Solution {

    public int[][] generateMatrix(int n) {
        int[][] resArray = new int[n][n];
        if(n==0) return resArray;

        int x=0;
        int y=0;
        int [] xStep = {0,1,0,-1};
        int [] yStep = {1,0,-1,0};
        int j = 0;
        for(int i=0;i<n*n;i++){

            resArray[x][y] = i+1;

            int xn = x+xStep[j];
            int yn = y+yStep[j];

            if(xn<0||xn==n||yn<0||yn==n||resArray[xn][yn]!=0){

                j = (j+1)%4;

            }
            x= x+xStep[j];
            y= y+yStep[j];

        }


        return resArray;
    }

    public static void main(String[] args){
        _58Solution so = new _58Solution();
        int [][] res = so.generateMatrix(7);
        for(int[] r:res){
            for(int i:r){
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
