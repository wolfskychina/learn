package leetcode.a800;
/**
 * Goat Latin 
 * {easy}
 */
public class _824Solution {
   
    public String toGoatLatin(String sentence) {

        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int i=1;
        for(String str:strs){

            if(str.startsWith("a")||
            str.startsWith("e")||
            str.startsWith("i")||
            str.startsWith("o")||
            str.startsWith("u")||
            str.startsWith("A")||
            str.startsWith("E")||
            str.startsWith("I")||
            str.startsWith("O")||
            str.startsWith("U")){
                sb.append(str);
            }else{
                sb.append(str.substring(1)).append(str.substring(0,1));
            }
            sb.append("ma");
            for(int j=0;j<i;j++){
                sb.append("a");
            }
            
            sb.append(" ");
            i++;
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
