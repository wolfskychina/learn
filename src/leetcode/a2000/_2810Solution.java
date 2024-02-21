package leetcode.a2000;
/**
 * 故障键盘
 * {easy}
 */
public class _2810Solution {
   
    public String finalString(String s) {

        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){

            if(arr[i]=='i')
                swap(arr,i);
        }

        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            if(c!='i')
                sb.append((char)c);
        }
        return sb.toString();
    }

    private void swap(char [] str, int end){

        for(int i=0;i<end-1-i;i++){
            char tmp = str[i];
            str[i] =str[end-1-i];
            str[end-1-i]= tmp;
        }
    }
}
