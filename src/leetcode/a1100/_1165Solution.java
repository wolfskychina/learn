package leetcode.a1100;
/**
 * 单行键盘，拼写一个单词需要移动的距离
 * {easy}
 */
public class _1165Solution {
   
    public int calculateTime(String keyboard, String word) {

        int[] map = new int[26];
        int idx =0;
        for(char c:keyboard.toCharArray()){
            map[c-'a'] = idx++;
        }

        word = keyboard.substring(0,1)+word;
        int count=0;
        char[] arr = word.toCharArray();
        for(int i=1;i<arr.length;i++){
            count+= Math.abs(map[arr[i]-'a']-map[arr[i-1]-'a']);
        }
        return count;
    }
}
