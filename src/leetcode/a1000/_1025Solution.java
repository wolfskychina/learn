package leetcode.a1000;
/**
 * 减除数博弈
 */
public class _1025Solution {
   
    /**
     * {game theory}
     * 数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
    无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
    因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
    N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
     */
    public boolean divisorGame(int n) {
        return  n%2==0;
    }
    
}
