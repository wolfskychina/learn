package leetcode.a2000;

public class _2748Solution {
   
    public int countBeautifulPairs(int[] nums) {

        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){

                if(gcd(getFirstDigit(nums[i]),nums[j]%10)==1)
                    count++;
            }
        }

        return count;
    }

    private int getFirstDigit(int i){
        while(i/10!=0){
            i/=10;
        }
        return i%10;
    }

    private int gcd(int i,int j){

        if(i==0||j==0) return 0;
        if(i==j) return  i;
        if(i<j){
            int tmp =j;
            j=i;
            i=tmp;
        }
        while(i%j!=0){
            int tmp = i%j;
            i=j;
            j=tmp;
        }
        return j;
    }

    /**
     * 更快的方式
     * @param nums
     * @return
     */
    public int countBeautifulPairs1(int[] nums) {

        int ans = 0;
        int[] cnt = new int[10];
        for(int num : nums) {
            for(int d = 1; d < 10; d++) {
                if(cnt[d] > 0 && gcd(num % 10, d) == 1) ans += cnt[d];
            }
            while(num >= 10) num /= 10;
            cnt[num]++;
        }

        return ans;
    }
}
