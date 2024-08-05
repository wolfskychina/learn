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
  
    /**
     * 速度很慢
     * @param digits
     * @return
     */
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

    /**
     * 模拟回溯，使用循环而不是递归
     * @param digits
     * @return
     */
    public int[] findEvenNumbers2(int[] digits) {
        // 数字出现次数统计数组，长度为10，对应0到9
        int[] map = new int[10];
        
        // 统计digits数组中每个数字出现的次数
        for (int i : digits) {
            map[i]++;
        }
        
        // 结果数组，最大可能的组合数为9 * 9 * 5 = 405，稍微扩大一些
        int[] arr = new int[450];
        int idx = 0; // 结果数组的当前索引
        
        // 第一重循环，遍历数字1到9
        for (int i = 1; i < 10; i++) {
            if (map[i]-- > 0) { // 如果数字i在digits数组中存在
                // 第二重循环，遍历数字0到9
                for (int j = 0; j < 10; j++) {
                    if (map[j]-- > 0) { // 如果数字j在digits数组中存在
                        // 第三重循环，遍历偶数数字0, 2, 4, 6, 8
                        for (int k = 0; k < 10; k += 2) {
                            if (map[k]-- > 0) { // 如果数字k在digits数组中存在
                                // 构造满足条件的三位数，并添加到结果数组中
                                arr[idx++] = i * 100 + j * 10 + k;
                            }
                            map[k]++; // 恢复map[k]的值，准备下一次使用
                        }
                    }
                    map[j]++; // 恢复map[j]的值，准备下一次使用
                }
            }
            map[i]++; // 恢复map[i]的值，准备下一次使用
        }
        
        // 将有效部分复制到新数组并返回，长度为idx即为有效结果的数量
        return Arrays.copyOf(arr, idx);
    }
}
