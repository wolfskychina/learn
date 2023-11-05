package leetcode.a500;
/**
 * 实现复数的乘法
 */
public class _537Solution {
   
    public String complexNumberMultiply(String num1, String num2) {

        int[] s1 = split(num1);
        int[] s2 = split(num2);

        int a = s1[0]*s2[0]-s1[1]*s2[1];
        int b = s1[1]*s2[0]+s1[0]*s2[1];

        return String.valueOf(a)+"+"+String.valueOf(b)+"i";
    }

    private int[] split(String num){

        int i=0;
        if(num.charAt(i)=='-') i=1;
        while(num.charAt(i)!='+') i++;
        int l = Integer.parseInt(num.substring(0,i));
        int r=  Integer.parseInt(num.substring(i+1,num.length()-1));
        int res[] ={l,r};
        return res;
    }
}
