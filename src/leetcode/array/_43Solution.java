package leetcode.array;

public class _43Solution {

    public String multply(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        int[] pos =new int[m+n];

        for(int i=m-1;i>0;i--){
            for(int j=n-1;j>0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;

                int sum = pos[p2]+mul;
                pos[p1]+=sum/10;
                pos[p2]=sum%10;
                System.out.println("pos[p1] = "+pos[p1]);
                System.out.println("pos[p2] = "+pos[p2]);

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p:pos) if (!(sb.length()==0)&&p==0) sb.append(p);

        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String [] args){

        _43Solution so = new _43Solution();
        so.multply("87898798","99999");
    }
}
