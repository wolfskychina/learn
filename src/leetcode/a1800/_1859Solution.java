package leetcode.a1800;
/**
 * 将句子排序
 * {easy}
 */
public class _1859Solution {
   
    public String sortSentence(String s) {

        String[] ori =  s.split(" ");
        String[] res = new String[ori.length];

        for(String str:ori){
            res[str.charAt(str.length()-1)-'1'] = str.substring(0, str.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for(String str:res){
            sb.append(str).append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
