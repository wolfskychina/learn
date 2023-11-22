package leetcode.a600;

public class _688Solution {
   
    double res = 0.0;
    int [][] step = {};
    public double knightProbability(int n, int k, int row, int column) {

        // 递归调用，每一层的概率是一样的，每进一层，到达的概率是原来的八分之一
        for(int i=0;i<8;i++){
            int xx = row+step[i][0];
            int yy = column + step[i][1];
            if(!valid(xx,yy,n))
                break;
            visit(1/8, xx,yy,k);
        }

    }
}
