package leetcode.array;
/**
 * 扁平式遍历二维数组
 */
public class _251Solution {
    
    int[][] vec;
    int i =0;
    int j =0;

    public _251Solution(int[][] vec) {
        this.vec = vec;    
    }
    
    public int next() {
        jump();
        return vec[i][j++];
    }
    
    public boolean hasNext() {
        jump();
        return i<vec.length && vec[i].length!=0;
    }
   /**
    * jump函数用来跳过每一行的末尾和空行
     */ 
    private void jump(){
        while(i<vec.length && (j==vec[i].length || vec[i].length==0)){
            i++;
            j=0;
        }
    }

}
