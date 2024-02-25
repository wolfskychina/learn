package leetcode.a2000;
/**
 * 重拍字符形成目标字符串
 * 报纸剪切匿名信
 * {easy}
 */
public class _2287Solution {
   
    public int rearrangeCharacters(String s, String target) {

        int count[] = new int[26];
        int tar[] = new int[26];

        for(char c:s.toCharArray()){

            count[c-'a']++;
        }

        for(char c:target.toCharArray()){
            tar[c-'a']++;
        }

        int num = Integer.MAX_VALUE;

        for(int i=0;i<tar.length;i++){

            if(tar[i]!=0){
                
                num = Math.min(num,count[i]/tar[i]);
            }
        }

        return num==Integer.MAX_VALUE?0:num;


    }
}
