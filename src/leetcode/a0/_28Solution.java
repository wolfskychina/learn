package leetcode.a0;
/**
 * 字符串匹配方法
 */
public class _28Solution {

        public int strStr(String haystack, String needle) {
          if (!haystack.contains(needle)){
              return -1;
          }
          return haystack.indexOf(needle);
      }
}
