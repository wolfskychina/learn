package leetcode.a1100;
/**
 * 字符串转化后的各位数字
 */
public class _1945Solution {
   
    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(c-'a'+1);
        }
        String str = sb.toString();
        for(int i=0;i<k;i++){
            if(str.length()==1) break;
            str = compute(str);
        }

        return Integer.parseInt(str);
    }

    private String compute(String str){

        int sum = 0;
        for(char c:str.toCharArray()){
            sum+= c-'0';
        }

        return String.valueOf(sum);
        
    }
}
