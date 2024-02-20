package leetcode.a800;
/**
 * 将字符拆分为若长度为k的子数组
 * {easy}
 */
public class _2138Solution {
   
    public String[] divideString(String s, int k, char fill) {

        int n = s.length()/k;
        int m = s.length()%k;
        String[] res = new String[m==0?n:n+1];
        for(int i=0;i<n;i++){

            res[i] = s.substring(i*k,i*k+k);
        }

        if(m!=0){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<k-m;i++){
                sb.append(fill);
            }
            res[res.length-1]=s.substring(s.length()-m)+sb.toString();
        }

        return res;

    }
}
