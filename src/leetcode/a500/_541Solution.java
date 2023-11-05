package leetcode.a500;
/**
 * 反转字符串，要求每隔2k个字符，反转前k个字符
 */
public class _541Solution {
   
    public String reverseStr(String s, int k) {

        char[] a = s.toCharArray();

        int i=0;
        while(i<a.length){
            if(i+k>a.length){
                swap(a,i,a.length-1);
                i =a.length;
                break;
            }else{
                swap(a,i,i+k-1);
                i +=k;
            }
            if(i+k>a.length){
                break;
            }else{
                i+=k;
            }

        }

        return String.valueOf(a);

    }

    private void swap(char[] a,int l, int r){
        while(l<r){
            char tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }
}
