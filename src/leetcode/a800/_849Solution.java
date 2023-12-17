package leetcode.a800;
/**
 * 能够离最近的人的最远距离
 */
public class _849Solution {

    public int maxDistToClosest(int[] seats) {

        int count = 0;
        int i = 0;
        for (; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        int count2 = 0;
        int j = seats.length - 1;
        for (; j >= 0; j--) {
            if (seats[j] == 0) {
                count2++;
            } else {
                break;
            }
        }
        int max = 0;
        max = Math.max(count, count2);
        if (i == j)
            return max;
        int tmp = 0;
        int maxt = 0;
        while (i < j) {

            while(i<j&&seats[i]==1)
                i++;
            tmp=0;
            while(i<j &&seats[i]==0){
                i++;
                tmp++;
            }
            maxt = Math.max(maxt,tmp);
            while(i<j && seats[i]==1){
                i++;
            }

        }
        return (maxt+1)/2>max?(maxt+1)/2:max;
    }
}
