package leetcode.a400;

public class _497Solution {

   
    int [][] sides ;
    int ridx = -1;
    int [][] rects;

    /**
     * 按照矩形点的数量分配概率,但是无法通过某些测试案例
     * @param rects
     */
    public _497Solution(int[][] rects) {
        this.rects = rects;

        sides = new int[rects.length][2];
        int num = 0;
        for(int i=0;i<rects.length;i++){

            num = (rects[i][3]-rects[i][1]+1)*(rects[i][2]-rects[i][0]+1);
            sides[i][0] = ridx+1;
            sides[i][1] = ridx+num;
            ridx += num;
        }

    }
    
    public int[] pick() {

          int p =  (int)Math.random()*(ridx+1);
          int i =0;
          while(i<sides.length && sides[i][1]<p)
          {  i++;}
          int x1 = rects[i][0];
          int y1 = rects[i][1];
          int x2 = rects[i][2];
          int y2 = rects[i][3];

          int x = x1 + (int)Math.random()*(x2-x1+1);
          int y = y1 + (int)Math.random()*(y2-y1+1);
          int[] res = new int[2];
          res[0] = x;
          res[1] = y;
          return res;



    }
}
