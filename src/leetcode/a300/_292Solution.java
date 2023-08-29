package leetcode.a300;

public class _292Solution {
   
    /**
     * 典型的dp问题，本次的操作至少有种选择
     * 拿掉1,2,3个之后，对应的dp值是false
     * 但是这个在n比较大的时候会超时
     * @param n
     * @return
     */
    public boolean canWinNim2(int n) {

        if(n==1 || n==2||n==3) return true;
        boolean c1= true;
        boolean c2= true;
        boolean c3= true;
        boolean c4 = false;

        for(int i =4;i<=n;i++){
            // 根据这里的规律，连续三个1才会出现0
            // 出现0后，会出现连续三个1
            c4 = c3&&c2&&c1?false:true;
            c1 = c2;
            c2 = c3;
            c3 = c4;
        }

        return c4;


    }

    /**
     * 根据dp发现的规律
     * 1110循环的规律
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {

        if(n%4==0) return false;
        return true;
    }

}
