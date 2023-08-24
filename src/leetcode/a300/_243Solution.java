package leetcode.a300;

/**
 * 判断两个单词在字典中的最近距离
 * 单词可能在字典中出现多次
 * 两个单词不相同
 */
public class _243Solution {

    /**
     * 巧妙的运用了类似双指针的原理，只保留每个单词最新出现的位置（因为是逐渐向后比较的，前面出现过的
     * 相同单词肯定距离会更远
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int word1P = -n, word2P = -n;
        int distance = n;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                distance = Math.min(distance, i - word2P);
                word1P = i;
            }
            else if(wordsDict[i].equals(word2)){
                distance = Math.min(distance, i - word1P);
                word2P = i;
            }
        }
        return distance;
    }
}
