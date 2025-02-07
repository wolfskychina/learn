package leetcode.a1900;

/**
 * 能够组成的最长快乐字符串
 * 找到最长的快乐字符串，且快乐字符串中不含有三个连续相同的字母。
 * 相邻不同问题
 * {greedy}
 */
public class _1405Solution {

    /**
     * 贪心策略：
     * 
     * 尽可能优先使用当前数量最多的字母，因为最后同一种字母剩余的越多，
     * 越容易出现字母连续相同的情况。如果构建完成最长的快乐字符串后还存在剩余未选择的字母，
     * 则剩余的字母一定为同一种字母且该字母的总数量最多。
     * 依次从当前数量最多的字母开始尝试，如果发现加入当前字母会导致出现三个连续相同字母，
     * 则跳过当前字母，直到我们找到可以添加的字母为止。实际上每次只会在数量最多和次多的字母中选择一个。
     * 如果尝试所有的字母都无法添加，则直接退出，此时构成的字符串即为最长的快乐字符串。
     **/
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;

        for (int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0)) {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0)
                    || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0)
                    || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;
            }
        }
        return sb.toString();
    }
}
