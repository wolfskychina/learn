package leetcode.a900;
/**
 * 判断一个字符串是不是可能的长按键造成的错误输入
 * {easy}
 */
public class _925Solution {
   
    public boolean isLongPressedName(String name, String typed) {
        char[] na = name.toCharArray();
        char[] tp = typed.toCharArray();
        int i=0;
        int j=0;
        while(i<na.length&&j<tp.length){
            if(na[i]!=tp[j]) return false;
            int tmp1 =0;
            int tmp2=0;
            while(i<na.length-1&&na[i]==na[i+1])
              {  i++;tmp1++;}
            while(j<tp.length-1&&tp[j]==tp[j+1]){
                j++;tmp2++;
            }
            if(tmp1>tmp2) return false;
            i++;
            j++;
        }
        if(i==na.length&&j==tp.length) return true;
        return false;

    }
}
