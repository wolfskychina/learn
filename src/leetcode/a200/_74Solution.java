package leetcode.a200;

public class _74Solution {

    public boolean searchMatrix(int[][] matrix, int target){

        int row=matrix.length;
        int col = matrix[0].length;
        int lowX =0;
        int lowY =0;
        int hiX = row-1;
        int hiY = col-1;
        int midX;
        int midY;
        while(lowX*row+lowY<hiX*row+hiY){

            int mid = lowX*row+lowY +(hiX*row+hiY-lowX*row-hiY)/2;
            midX = mid/row;
            midY = mid%col;

            if(matrix[midX][midY]>target){
                hiX = midX;
                hiY = midY;
            }else if(matrix[midX][midY]<target){
                lowX = midX +1;
                lowY = midY +1;
            }else{
                return true;
            }
        }

        return false;
    }
}
