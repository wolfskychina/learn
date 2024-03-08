package leetcode.a2000;
/**
 * 能够到达的最远节点
 * {easy}
 */
public class _2833Solution {
   
    public int furthestDistanceFromOrigin(String moves) {

        int countL = 0;
        int countR = 0;
        int count_ = 0;
        for(char c:moves.toCharArray()){
    
            switch (c) {
                case 'L':
                    countL++;
                    break;
                case 'R':
                    countR++;
                    break;
                default:
                    count_++;
                    break;
            }
        }
    
            return count_+Math.abs(countL-countR);
        }
}
