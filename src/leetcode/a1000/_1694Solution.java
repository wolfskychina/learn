package leetcode.a1000;
/**
 * 重新格式化电话号码
 * {easy}
 */
public class _1694Solution {
   
    public String reformatNumber(String number) {

        char [] arr = number.toCharArray();
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!= ' '&&arr[j]!='-'){
                arr[i++]=arr[j];
            }
        }
        // total i chars
        int remain = i;
        StringBuilder sb = new StringBuilder();
        int j=0;
        for(;remain>4;remain-=3,j+=3){
            
            sb.append(arr[j]).append(arr[j+1]).append(arr[j+2]).append('-');
        }
        if(remain==0){
            sb.setLength(sb.length()-1);
            return sb.toString();
        }
        if(remain ==1){
            return sb.append(arr[j]).toString();
        }
        if(remain ==2){
            return sb.append(arr[j]).append(arr[j+1]).toString();
        }
        if(remain ==3){
            return sb.append(arr[j]).append(arr[j+1]).append(arr[j+2]).toString();
        }
        return sb.append(arr[j]).append(arr[j+1]).append('-').append(arr[j+2]).append(arr[j+3]).toString();
    }
}
