package leetcode.a800;
/**
 * 三种分数的小球，抽取k个所能组成的最大值
 * {easy}
 */
public class _2600Solution {
   
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        if(k>=0 &&k<=numOnes){
            return k;
        }else if(k>numOnes && k<=numOnes+numZeros)
            return numOnes;
        else 
            return numOnes-(k-numOnes-numZeros);
    }
}
