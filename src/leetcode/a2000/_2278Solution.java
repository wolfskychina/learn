package leetcode.a2000;

/**
 * 某个特定字符在单词中出现的频率
 * {easy}
 */
public class _2278Solution {

  public int percentageLetter(String s, char letter) {
    int[] cnts = new int[26];
    for (char c : s.toCharArray())
      cnts[c - 'a']++;
    int sum = 0;
    for (int i = 0; i < 26; i++)
      sum += cnts[i];
    return 100 * cnts[letter - 'a'] / sum;
  }
}
