package leetcode.a400;

/**
 * 给一个单词字符串数组表示的句子
 * 问这个句子能够在一个长rows，宽cols的文本框中
 * 完整的显示多少次
 */
public class _418Solution {

    /**
     * 最近本的模拟填充，1475ms，比较慢
     * 
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {

        int[] len = new int[sentence.length];

        for (int i = 0; i < sentence.length; i++) {

            len[i] = sentence[i].length();
        }

        int r = 0;
        int remain = cols;
        int wordIdx = 0;
        int res = 0;
        int WORDNUM = sentence.length - 1;
        while (r < rows) {

            remain = cols;

            while (remain - len[wordIdx] >= 0) {
                // 句子到末端，句子数+1
                remain -= len[wordIdx] + 1;
                if (wordIdx == WORDNUM) {
                    wordIdx = 0;
                    res++;

                } else {
                    wordIdx++;
                }

            }
            // 此行已满，切换到下一行
            r++;
        }
        return res;

    }

    /**
     * {dp}
     * 只需要对每一个词计算它开头的时候下一行该以哪个词开头
     * 同时每一个单词开头的时候，这一行能够增加多少个句子也是固定的
     */
    public int wordsTyping2(String[] sentence, int rows, int cols) {
        int n = sentence.length, wordIndex = 0;
        int[] len = new int[n];
        for(int i = 0; i < n; i++){
            len[i] = sentence[i].length();
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            wordIndex = i;
            int currRowLen = 0, times = 0;
            while(currRowLen + len[wordIndex] <= cols){
                currRowLen += len[wordIndex++] + 1;
                if(wordIndex == n){
                    wordIndex = 0;
                    times++;
                }
            }
            dp[i] = wordIndex + times * 100;
        }
        int index = 0, res = 0;
        wordIndex = 0;
        while(index < rows){
            index++;
            res += dp[wordIndex] / 100;
            wordIndex = dp[wordIndex] % 100;
        }
        return res;
    }
    /*
     * 选100主要是为了用一个变量同时储存这一行增加的句子数
     * 和下一行的起始的单词序号。因为可能有句子的长度最大才到100，
     * 所以用mod 100是够用的。那么除了最后的两位，前面的位数用来保存
     *  这一行 增加的句子数。假设句子最少只有一个字符，
     * 那么根据（1 <= rows, cols <= 2 * 10^4），
     * 同一行最多也就增加10000个句子，用整数剩余位保存完全够用，
     * 所以选择1000,10000都是可以的。但是不能用后两位非0的数字，
     * 前后两种数据会干扰。。
     */

}
