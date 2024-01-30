package leetcode.a800;
/**
 * 求数字的反码
 * {easy}
 */
public class _1009Solution {
   
    public int bitwiseComplement(int n) {

        // if(n==0) return 1;
        int bit = 0;
        int ori = n;
        while(n!=0){
            bit++;
            n = n>>1;
        }
        
        int res = ori^(Integer.MAX_VALUE>>>(31-bit));
        //int res=ori^((int)Math.pow(2,bit)-1);
        return res;
    }

    public int bitwiseComplement1(int N) {
        
        int temp = 2;
        
        while(temp<=N){
            
            temp = temp << 1;
        }
        
        return temp - N - 1;
        
    }


    public static void main(String[] args){
        _1009Solution so = new _1009Solution();
        // so.bitwiseComplement(5);
        for(int i=31;i>=0;i--){
            System.out.println(Integer.toBinaryString(Integer.MAX_VALUE>>>i) );
        }
        int res = Integer.MAX_VALUE>>>(31);
        int res2 = Integer.MAX_VALUE>>>(3);  
    }
}
