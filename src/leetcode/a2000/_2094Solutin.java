package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * 找出能够组合出的三位偶数
 */
public class _2094Solutin {
   
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new TreeSet<>();
        Arrays.sort(digits);
        for(int i=0;i<digits.length;i++){
            if(digits[i]==0) continue;

            for(int j=0;j<digits.length;j++){
                if(j==i) continue;

                for(int k=0;k<digits.length;k++){
                    if(k==i||k==j||digits[k]%2==1) continue;
                            res.add(digits[k]+digits[j]*10+digits[i]*100);
                }
            }

        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 遍历所有可能的三位偶数
     * @param digits
     * @return
     */
    public int[] findEvenNumbers1(int[] digits) {
        List<Integer> resultList = new ArrayList<>();
        int[] digitFreq = new int[10];
        for (int i = 0; i < digits.length; i++) {
            digitFreq[digits[i]]++;
        }
 
        for (int i = 100; i < 999; i += 2) {
            int[] currFreq = new int[10];
            int curr = i;
            while (curr != 0) {
                currFreq[curr % 10]++;
                curr /= 10;
            }
 
            boolean found = true;
            for (int j = 0; j < 10; j++) {
                if (digitFreq[j] < currFreq[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                resultList.add(i);
            }
        }
 
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;


    }
}
