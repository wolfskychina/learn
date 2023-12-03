package leetcode.a700;
/**
 * 森林里的兔子
 */
public class _781Solution {
   
    /**
     * 根据最少的原则，如果有n只兔子回答有n-1只兔子跟我颜色相同，那么这n只兔子可以同一种颜色
     * 如果还有别的兔子也回答n-1只兔子跟我颜色相同，那么也不可能是同一种颜色，只能是另外的颜色
     * {Math},{Pigeonhole Principle}
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {

        int total =0;
        int[] current = new int[1002];
        for(int i:answers){

            if( current[i+1] == 0){
                total+=i+1;
            }
            current[i+1] = (current[i+1]+1)%(i+1);

        }
        return total;
    }
}
