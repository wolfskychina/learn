package leetcode.a800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 最长字符串链的长度
 */
public class _1048Solution {
   
    class Dp{
        String str;
        int len;

        public Dp(String str,int len){
            this.str = str;
            this.len = len;
        }
    }
    public int longestStrChain(String[] words) {

        List<Dp>[] arr = new ArrayList[17];

        for(int i=0;i<arr.length;i++){

            arr[i] = new ArrayList<>();
        }
        for(String str:words){
            arr[str.length()].add(new Dp(str,1));
        }
        int max = 1;

        for(int i=2;i<arr.length;i++){

            List<Dp> last = arr[i-1];
            List<Dp> now = arr[i];
            if(now.size()==0 || last.size()==0) continue;
            for(Dp dp: now){

                for(Dp dpl:last){
                    if(ifcontains(dp.str, dpl.str)){
                        dp.len = Math.max(dp.len,dpl.len+1);
                        max = Math.max(max, dp.len);
                    }
                }

            }
        }

        return max;

    }

    private boolean ifcontains(String str, String str2) {

        for(int i=0;i<str.length();i++){
            String string= str.substring(0, i)+str.substring(i+1);
            if(string.equals(str2)) return true;
        }
        return false;
    }

    public int longestStrChain1(String[] words) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            cnt.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (cnt.containsKey(prev)) {
                    cnt.put(word, Math.max(cnt.get(word), cnt.get(prev) + 1));
                }
            }
            res = Math.max(res, cnt.get(word));
        }
        return res;
    }

    public static void main(String[] args){

        _1048Solution so = new _1048Solution();
        String[] str = {"a","b","ba","bca","bda","bdca"};
        so.longestStrChain(str);
    }
}
