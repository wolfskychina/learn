package leetcode.a1500;
/**
 * 替换所有的问号
 * {easy}
 */
public class _1576Solution {
   
    public String modifyString(String s) {

        char[] arr = s.toCharArray();
        if(arr.length==1){
            if(arr[0]=='?') return "a";
            else
                return s;
        }
        for(int i=0;i<arr.length;i++){

            if(arr[i]!='?') continue;

            for(char j='a';j<='z';j++){
                if((i!=0&&arr[i-1]==j)||(i!=arr.length-1&&arr[i+1]==j))
                    continue;
                else   
                    arr[i] = j;
            }
            
        }

        return new String(arr);
    }
}
